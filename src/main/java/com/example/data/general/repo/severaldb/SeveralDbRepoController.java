package com.example.data.general.repo.severaldb;

import com.example.data.model.AbstractEntity;
import com.example.data.util.DbType;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class SeveralDbRepoController<T extends AbstractEntity, I> {

    private final SeveralDbRepoService<T, I> service;

    public SeveralDbRepoController(SeveralDbRepoServiceFactory factory,
                                   SpringDataRepoFactory repoFactory,
                                   Class<T> clazz) {
        this.service = factory.getSeveralDbRepoService(clazz, repoFactory);
    }

    @PostMapping("/{dbType}")
    public ResponseEntity<?> create(@RequestBody T t,
                                    @ApiParam(value = "Тип БД", required = true) @PathVariable DbType dbType) {
        return service.create(t, dbType);
    }

    @GetMapping(value = {"/{dbType}", "/{id}/{dbType}"})
    public ResponseEntity<?> read(@PathVariable(required = false) I id,
                                  @ApiParam(value = "Тип БД", required = true) @PathVariable DbType dbType) {
        return service.readAll(id, dbType);
    }

    @PutMapping("/{dbType}")
    public ResponseEntity<?> update(@RequestBody T t, @ApiParam(value = "Тип БД", required = true) @PathVariable DbType dbType) {
        return service.update(t, dbType);
    }

    @DeleteMapping("/{id}/{dbType}")
    public ResponseEntity<?> delete(@ApiParam(required = true) @PathVariable I id,
                                    @ApiParam(value = "Тип БД", required = true) @PathVariable DbType dbType) {
        return service.delete(id, dbType);
    }
}
