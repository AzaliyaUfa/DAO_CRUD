package com.example.data.controller.repo;

import com.example.data.general.repo.severaldb.SeveralDbRepoController;
import com.example.data.general.repo.severaldb.SeveralDbRepoServiceFactory;
import com.example.data.general.repo.severaldb.SpringDataRepoFactory;
import com.example.data.model.entity.Pet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/crud/several/repo/pet")
public class PetSeveralDbRepoController extends SeveralDbRepoController<Pet, Long> {
    public PetSeveralDbRepoController(SeveralDbRepoServiceFactory factory,
                                      SpringDataRepoFactory repoFactory) {
        super(factory, repoFactory, Pet.class);
    }
}
