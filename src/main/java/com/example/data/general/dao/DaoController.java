package com.example.data.general.dao;


import com.example.data.model.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class DaoController<T extends AbstractEntity, I> {

    private final DaoService<T, I> daoService;

    public DaoController(DaoServiceFactory serviceFactory,
                         AbstractDaoFactory daoFactory,
                         Class<T> clazz) {
        this.daoService = serviceFactory.getDaoService(clazz, daoFactory);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody T t) {
        return daoService.create(t);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable I id) {
        return daoService.read(id);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody T t) {
        return daoService.update(t);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable I id) {
        return daoService.delete(id);
    }
}

