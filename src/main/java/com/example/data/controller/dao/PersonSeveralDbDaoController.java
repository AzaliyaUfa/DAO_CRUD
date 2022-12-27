package com.example.data.controller.dao;

import com.example.data.general.dao.severaldb.DBDaoFactory;
import com.example.data.general.dao.severaldb.SeveralDbDaoController;
import com.example.data.general.dao.severaldb.SeveralDbDaoServiceFactory;
import com.example.data.model.entity.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/crud/several/dao/person")
public class PersonSeveralDbDaoController extends SeveralDbDaoController<Person, Long> {

    public PersonSeveralDbDaoController(SeveralDbDaoServiceFactory factory,
                                        DBDaoFactory dbDaoFactory) {
        super(factory, dbDaoFactory, Person.class);
    }
}
