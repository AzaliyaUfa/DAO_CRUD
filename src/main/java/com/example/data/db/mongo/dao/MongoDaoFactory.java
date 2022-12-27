package com.example.data.db.mongo.dao;

import com.example.data.general.dao.AbstractDao;
import com.example.data.general.dao.AbstractDaoFactory;
import com.example.data.model.AbstractEntity;
//import com.example.data.util.DBFactoryType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component//(DBFactoryType.BeanNames.MONGODB_DAO)
@ConditionalOnProperty(name = "mongo.db.enabled", havingValue = "true")
public class MongoDaoFactory implements AbstractDaoFactory {

    private final MongoOperations mongoOperations;

    public MongoDaoFactory(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public <T extends AbstractEntity, I> AbstractDao<T, I> getDao(Class<T> clazz) {
        return new MongoDao<>(clazz, mongoOperations);
    }
}
