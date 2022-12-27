package com.example.data.db.neo4j.dao;

import com.example.data.general.dao.AbstractDao;
import com.example.data.model.AbstractEntity;
import org.springframework.data.neo4j.core.Neo4jTemplate;

public class Neo4jDao<T extends AbstractEntity, I> extends AbstractDao<T, I> {

    private final Neo4jTemplate template;

    public Neo4jDao(Class<T> clazz, Neo4jTemplate template) {
        super(clazz);
        this.template = template;
    }

    @Override
    public T create(T t) {
        return template.save(t);
    }

    @Override
    public T read(I id) {
        return template.findById(id, clazz).orElse(null);
    }

    @Override
    public T update(T t) {
        template.save(t);
        return null;
    }

    @Override
    public boolean delete(I id) {
        template.deleteById(id, clazz);
        return true;
    }
}
