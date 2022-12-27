package com.example.data.db.cassandra.dao;

import com.example.data.general.dao.AbstractDao;
import com.example.data.general.dao.AbstractDaoFactory;
import com.example.data.model.AbstractEntity;
//import com.example.data.util.DBFactoryType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

@Component//(DBFactoryType.BeanNames.CASSANDRA_DAO)
@ConditionalOnProperty(name = "cassandra.db.enabled", havingValue = "true")
public class CassandraDaoFactory implements AbstractDaoFactory {

    private final CassandraOperations cassandraOps;

    public CassandraDaoFactory(CassandraOperations cassandraOps) {
        this.cassandraOps = cassandraOps;
    }

    @Override
    public <T extends AbstractEntity, I> AbstractDao<T, I> getDao(Class<T> clazz) {
        return new CassandraDao<>(clazz, cassandraOps);
    }
}
