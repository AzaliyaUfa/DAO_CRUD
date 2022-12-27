package com.example.data.controller.dao;

import com.example.data.general.dao.AbstractDaoFactory;
import com.example.data.general.dao.DaoController;
import com.example.data.general.dao.DaoServiceFactory;
import com.example.data.model.entity.Pet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/crud/dao/pet")
public class PetDaoController extends DaoController<Pet, Long> {

    public PetDaoController(DaoServiceFactory serviceFactory,
                            AbstractDaoFactory daoFactory) {
        super(serviceFactory, daoFactory, Pet.class);
    }
}
