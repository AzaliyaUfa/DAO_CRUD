package com.example.data.general.dao;

import com.example.data.model.AbstractEntity;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public class DaoService<T extends AbstractEntity, I> {

    private final AbstractDao<T, I> dao;

    public DaoService(Class<T> clazz,
                      AbstractDaoFactory daoFactory) {
        this.dao = daoFactory.getDao(clazz);
    }

    public ResponseEntity<T> create(T t) {
        return ResponseEntity.ok(dao.create(t));
    }

    public ResponseEntity<T> read(I id) {
        if(Objects.isNull(dao.read(id))) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(dao.read(id));
        }
    }

    public ResponseEntity<T> update(T t) {
        if(Objects.isNull(dao.read((I) t.getId()))) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(dao.update(t));
        }
    }

    public ResponseEntity<?> delete(I id) {
        try {
            dao.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

}

