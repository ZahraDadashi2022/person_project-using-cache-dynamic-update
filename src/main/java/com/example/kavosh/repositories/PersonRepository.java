package com.example.kavosh.repositories;

import com.example.kavosh.base.BaseRepository;
import com.example.kavosh.models.entities.PersonEntity;

public interface PersonRepository extends BaseRepository<PersonEntity, Long> {
    PersonEntity findByUsername(String username);

}
