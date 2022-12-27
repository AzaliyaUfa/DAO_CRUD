package com.example.data.general.repo.severaldb;


import com.example.data.model.AbstractEntity;
import com.example.data.util.DbType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SeveralDbRepoService<T extends AbstractEntity, I> {

    private final Class<T> clazz;

    private final SpringDataRepoFactory repoFactory;

    public SeveralDbRepoService(Class<T> clazz,
                                SpringDataRepoFactory repoFactory) {
        this.clazz = clazz;
        this.repoFactory = repoFactory;
    }

    public ResponseEntity<T> create(T t, DbType dbType) {
        return ResponseEntity.ok(repoFactory.getRepo(clazz, dbType).save(t));
    }

    public ResponseEntity<T> read(I id, DbType dbType) {
        if (repoFactory.getRepo(clazz, dbType).findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(repoFactory.getRepo(clazz, dbType).findById(id).get());
        }
    }

    public ResponseEntity<List<T>> readAll(I id, DbType dbType) {
        if(Objects.isNull(id)) {
            List<T> list = new ArrayList<>();
            repoFactory.getRepo(clazz, dbType).findAll().forEach(list::add);
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.ok(Collections.singletonList(read(id, dbType).getBody()));
        }

    }

    public ResponseEntity<T> update(T t, DbType dbType) {
        if (repoFactory.getRepo(clazz, dbType).findById(t.getId()).isPresent()) {
            return ResponseEntity.ok(repoFactory.getRepo(clazz, dbType).save(t));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> delete(I id, DbType dbType) {
        try {
            repoFactory.getRepo(clazz, dbType).deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
