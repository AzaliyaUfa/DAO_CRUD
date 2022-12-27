package com.example.data.db.neo4j.repo;

import com.example.data.model.entity.Pet;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetNeo4jRepo extends Neo4jRepository<Pet, Long> {

}
