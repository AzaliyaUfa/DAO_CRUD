package com.example.data.db.mongo.dao;

import com.example.data.general.dao.AbstractDao;
import com.example.data.model.AbstractEntity;
import com.mongodb.client.result.DeleteResult;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class MongoDao<T extends AbstractEntity, I> extends AbstractDao<T, I> {

    private final MongoOperations mongoOperations;

    public MongoDao(Class<T> clazz,
                    MongoOperations mongoOperations) {
        super(clazz);
        this.mongoOperations = mongoOperations;
    }

    @Override
    public T create(T t) {
        mongoOperations.insert(t);
        return t;
    }

    @Override
    public T read(I id) {
        return mongoOperations.findById(id, clazz);
    }

    @Override
    public T update(T t) {
        mongoOperations.save(t);
        return t;
    }

    @Override
    public boolean delete(I id) {
        DeleteResult dr = mongoOperations.remove(new Query(Criteria.where("id").is(id)), clazz);
        return dr.getDeletedCount() > 0;
    }
}
