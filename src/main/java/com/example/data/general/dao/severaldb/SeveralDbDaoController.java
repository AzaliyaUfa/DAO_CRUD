package com.example.data.general.dao.severaldb;

import com.example.data.model.AbstractEntity;
import com.example.data.util.DbType;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class SeveralDbDaoController<T extends AbstractEntity, I> {

    private final SeveralDbDaoService<T, I> service;

    public SeveralDbDaoController(SeveralDbDaoServiceFactory factory,
                                  DBDaoFactory dbDaoFactory,
                                  Class<T> clazz) {
        this.service = factory.getSeveralDbDaoService(clazz, dbDaoFactory);
    }

    @PostMapping("/{dbType}")
    public ResponseEntity<?> create(@RequestBody T t,
                                    @ApiParam(value = "Тип БД", required = true) @PathVariable DbType dbType) {
        return service.create(t, dbType);
    }

    @GetMapping("/{id}/{dbType}")
    public ResponseEntity<?> read(@ApiParam(required = true) @PathVariable I id,
                                  @ApiParam(value = "Тип БД", required = true) @PathVariable DbType dbType) {
        return service.read(id, dbType);
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
