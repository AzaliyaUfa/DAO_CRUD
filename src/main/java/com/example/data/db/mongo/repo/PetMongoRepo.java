package com.example.data.db.mongo.repo;

import com.example.data.model.entity.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetMongoRepo extends MongoRepository<Pet, Long> {
}
