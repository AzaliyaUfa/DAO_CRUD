package com.example.data.db.mongo.repo;

import com.example.data.model.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMongoRepo extends MongoRepository<Person, Long> {
}
