package com.alex.development.tools.project.builder.common.crud;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T extends Object, ID extends Serializable> {

    @Autowired(required = true)
    private BaseRepository<T, ID> baseRepository;

    public List<T> findAll() {
        return this.baseRepository.findAll();
    }

    public T findOne(ID id) {
        return (T) this.baseRepository.findOne(id);
    }

    public <S extends T> S save(S entity) {
        return (S) this.baseRepository.save(entity);
    }

    public ID delete(ID id) {
        this.baseRepository.delete(id);
        return id;
    }

}
