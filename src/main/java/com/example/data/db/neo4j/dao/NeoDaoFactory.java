package com.example.data.db.neo4j.dao;

import com.example.data.general.dao.AbstractDao;
import com.example.data.general.dao.AbstractDaoFactory;
import com.example.data.model.AbstractEntity;
//import com.example.data.util.DBFactoryType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Component;

@Component//(DBFactoryType.BeanNames.NEO4J_DAO)
@ConditionalOnProperty(name = "neo4j.db.enabled", havingValue = "true")
public class NeoDaoFactory implements AbstractDaoFactory {

    private final Neo4jTemplate template;

    public NeoDaoFactory(Neo4jTemplate template) {
        this.template = template;
    }

    @Override
    public <T extends AbstractEntity, I> AbstractDao<T, I> getDao(Class<T> clazz) {
        return new Neo4jDao<>(clazz, template);
    }

}
