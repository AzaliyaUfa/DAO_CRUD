package com.example.data.controller.dao;

import com.example.data.general.dao.severaldb.DBDaoFactory;
import com.example.data.general.dao.severaldb.SeveralDbDaoController;
import com.example.data.general.dao.severaldb.SeveralDbDaoServiceFactory;
import com.example.data.model.entity.Pet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/crud/several/dao/pet")
public class PetSeveralDbDaoController extends SeveralDbDaoController<Pet, Long> {

    public PetSeveralDbDaoController(SeveralDbDaoServiceFactory factory,
                                     DBDaoFactory dbDaoFactory) {
        super(factory, dbDaoFactory, Pet.class);
    }
}
