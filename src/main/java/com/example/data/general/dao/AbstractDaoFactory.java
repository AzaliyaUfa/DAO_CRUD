package com.example.data.general.dao;


import com.example.data.model.AbstractEntity;

public interface AbstractDaoFactory {

    <T extends AbstractEntity, I> AbstractDao<T, I> getDao(Class<T> clazz);
}

