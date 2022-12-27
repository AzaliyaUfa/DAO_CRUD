package com.example.data.db.cassandra.dao;

import com.example.data.general.dao.AbstractDao;
import com.example.data.model.AbstractEntity;
import org.springframework.data.cassandra.core.CassandraOperations;

public class CassandraDao<T extends AbstractEntity, I> extends AbstractDao<T, I> {

    private final CassandraOperations cassandraOps;

    public CassandraDao(Class<T> clazz,
                        CassandraOperations cassandraOps) {
        super(clazz);
        this.cassandraOps = cassandraOps;
    }

    @Override
    public T create(T t) {
        return cassandraOps.insert(t);
    }

    @Override
    public T read(I id) {
        T sd = cassandraOps.selectOneById(id, clazz);
        return cassandraOps.selectOneById(id, clazz);
    }

    @Override
    public T update(T t) {
        return cassandraOps.update(t);
    }

    @Override
    public boolean delete(I id) {
        return cassandraOps.deleteById(id, clazz);
    }
}
