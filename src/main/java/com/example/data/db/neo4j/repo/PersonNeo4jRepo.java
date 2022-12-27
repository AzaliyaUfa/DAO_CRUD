package com.example.data.db.neo4j.repo;

import com.example.data.model.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonNeo4jRepo extends Neo4jRepository<Person, Long> {

}
