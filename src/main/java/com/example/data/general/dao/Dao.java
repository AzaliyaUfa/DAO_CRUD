package com.example.data.general.dao;


import com.example.data.model.AbstractEntity;

public interface Dao<T extends AbstractEntity, I> {

    T create(T t);

    T read(I id);

    T update(T t);

    boolean delete(I id);

}

