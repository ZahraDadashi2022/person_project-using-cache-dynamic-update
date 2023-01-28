package com.example.kavosh.services.Impl;

import com.example.kavosh.exceptionhandlers.GlobalException;
import com.example.kavosh.models.entities.PersonEntity;
import com.example.kavosh.repositories.PersonRepository;
import com.example.kavosh.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

import static org.hibernate.dialect.Database.CACHE;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService, UserDetailsService {

    public static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonEntity personEntity = personRepository.findByUsername(username);
        if (personEntity == null) {
            LOGGER.error("user not found in the database");
            throw new UsernameNotFoundException("user not found in the database");
        } else {
            LOGGER.info("user found in the database:{}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(
                new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(
                personEntity.getUsername(), personEntity.getPassword(), authorities);
    }

    @Override
    @Transactional
    public void save(PersonEntity personEntity) {
        LOGGER.info("saving new person{} to  db", personEntity.getLname());
        try {
            personEntity.setPassword(passwordEncoder.encode(personEntity.getPassword().trim()));
            personRepository.save(personEntity);
        } catch (DuplicateKeyException ex) {
            LOGGER.error("username can not be duplicated", ex);
            throw new GlobalException("username.can.not.be.duplicated");
        }
    }

    @Override
    @Transactional
    @Cacheable(cacheNames = "personDataById")
    public PersonEntity findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new GlobalException("id.not.found"));
    }

    @CacheEvict(cacheNames = "personDataById", allEntries=true)
    @Scheduled(cron="*/5 * * * *")
    public void removePersonData() {
        LOGGER.debug("Cache '{}' cleared.", CACHE);

    }

    @Override
    @Transactional
    public PersonEntity update(PersonEntity personEntity) {
        LOGGER.info("updating new person{} to  db", personEntity.getLname());
        return personRepository.save(personEntity);

    }

    //  getUser method for getting username from security context to find the logged-in user to
    // save project to that user.(It is used in save method in ProjectServiceImpl)
    @Override
    @Transactional
    public PersonEntity getUser(String username) {
        LOGGER.info("fetching username from database:{}", username);
        if (username == null) throw new GlobalException("username.does.not.exist");
        return personRepository.findByUsername(username);
    }
}
