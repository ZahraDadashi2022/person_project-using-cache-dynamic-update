package com.example.kavosh;

import com.example.kavosh.services.Impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaRepositories
@Configuration
@EnableCaching
public class KavoshApplication extends WebMvcConfigurerAdapter implements ApplicationRunner {

    public static void main(String[] args) {

        SpringApplication.run(KavoshApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // testing cache performance
    @Autowired
    PersonServiceImpl personService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("person data without Caching");
        System.out.println(personService.findById(1L));
        stopWatch.stop();
        stopWatch.start("person data with Caching");
        System.out.println(personService.findById(1L));
        stopWatch.stop();
        personService.removePersonData();
        stopWatch.start("person data after cache evict");
        System.out.println(personService.findById(1L));
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }
}
