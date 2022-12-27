package com.example.data.db.postgres.dao;


import com.example.data.general.dao.AbstractDao;
import com.example.data.general.dao.AbstractDaoFactory;
import com.example.data.model.AbstractEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//import com.example.data.util.DBFactoryType;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Component//(DBFactoryType.BeanNames.POSTGRES_DAO)
@ConditionalOnProperty(name = "postgres.db.enabled", havingValue = "true")
@Primary
public class PostgresDaoFactory implements AbstractDaoFactory {

    @PersistenceUnit
    private final EntityManagerFactory emf;

    public PostgresDaoFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public <T extends AbstractEntity, I> AbstractDao<T, I> getDao(Class<T> clazz) {
        return new PostgresDao<>(emf, clazz);
    }
}
