package com.example.kavosh.base;

import java.io.Serializable;

public interface BaseService<T , ID extends Serializable> {
    void save(T t);
    T findById(ID id);
    T update(T t);
}
