package com.example.data.general.dao.severaldb;

import com.example.data.model.AbstractEntity;
import org.springframework.stereotype.Component;

@Component
public class SeveralDbDaoServiceFactory {

    public <T extends AbstractEntity, I> SeveralDbDaoService<T, I> getSeveralDbDaoService(Class<T> clazz,
                                                                                          DBDaoFactory dbDaoFactory) {
        return new SeveralDbDaoService<>(clazz, dbDaoFactory);
    }
}
