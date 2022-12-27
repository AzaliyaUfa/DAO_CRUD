package com.example.data.general.dao;

import com.example.data.model.AbstractEntity;
import org.springframework.stereotype.Component;

@Component
public class DaoServiceFactory {
    public <T extends AbstractEntity, I> DaoService<T, I> getDaoService(Class<T> clazz,
                                                                        AbstractDaoFactory daoFactory) {
        return new DaoService<>(clazz, daoFactory);
    }

}

