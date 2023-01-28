package com.example.kavosh.services;

import com.example.kavosh.base.BaseService;
import com.example.kavosh.models.entities.PersonEntity;

public interface PersonService extends BaseService<PersonEntity, Long> {
    PersonEntity getUser(String username);
}
