package com.example.data.general.dao.severaldb;


import com.example.data.model.AbstractEntity;
import com.example.data.util.DbType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public class SeveralDbDaoService<T extends AbstractEntity, I> {

    private final Class<T> clazz;

    private final DBDaoFactory dbDaoFactory;

    public SeveralDbDaoService(Class<T> clazz,
                               DBDaoFactory dbDaoFactory) {
        this.clazz = clazz;
        this.dbDaoFactory = dbDaoFactory;
    }

    public ResponseEntity<T> create(T t, DbType dbType) {
        return ResponseEntity.ok(dbDaoFactory.getDaoFactory(dbType).getDao(clazz).create(t));
    }

    public ResponseEntity<T> read(I id, DbType dbType) {
        if (Objects.isNull(dbDaoFactory.getDaoFactory(dbType).getDao(clazz).read(id))) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(dbDaoFactory.getDaoFactory(dbType).getDao(clazz).read(id));
        }
    }

    public ResponseEntity<T> update(T t, DbType dbType) {
        return ResponseEntity.ok(dbDaoFactory.getDaoFactory(dbType).getDao(clazz).update(t));
    }

    public ResponseEntity<?> delete(I id, DbType dbType) {
        try {
            return dbDaoFactory.getDaoFactory(dbType).getDao(clazz).delete(id) ?
                    ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
