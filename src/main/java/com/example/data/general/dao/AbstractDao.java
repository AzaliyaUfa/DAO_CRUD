package com.example.data.general.dao;


import com.example.data.model.AbstractEntity;

public abstract class AbstractDao<T extends AbstractEntity, I> implements Dao<T, I> {

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class<T> clazz;

}

