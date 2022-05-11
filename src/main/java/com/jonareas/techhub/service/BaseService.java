package com.jonareas.techhub.service;

import com.jonareas.techhub.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends BaseEntity, ID extends Serializable> {

    T create(T entity) throws Exception;

    T update(T entity) throws Exception;

    List<T> getAll() throws Exception;

    T getById(ID id) throws Exception;

    void delete(ID id) throws Exception;

}
