package com.example.data.general.dao.severaldb;

import com.example.data.general.dao.AbstractDaoFactory;
import com.example.data.util.DbType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DBDaoFactory {

    private final Map<String, AbstractDaoFactory> beanMap;

    public DBDaoFactory(Map<String, AbstractDaoFactory> beanMap) {
        this.beanMap = beanMap;
    }

    public AbstractDaoFactory getDaoFactory(DbType dbType) {
        return beanMap.get(dbType.getDbName() + "DaoFactory");
    }

}