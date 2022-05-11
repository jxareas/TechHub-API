package com.jonareas.techhub.service.impl;

import com.jonareas.techhub.model.BaseEntity;
import com.jonareas.techhub.repository.BaseRepository;
import com.jonareas.techhub.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T extends BaseEntity, ID extends Serializable> implements BaseService<T, ID> {

    private final BaseRepository<T, ID> repository;

    BaseServiceImpl(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public T create(T entity) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public T update(T entity) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<T> getAll() throws Exception {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public T getById(ID id) throws Exception {
        try {
         return repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(ID id) throws Exception {
        try {
             repository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
