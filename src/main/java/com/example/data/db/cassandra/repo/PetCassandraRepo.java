package com.example.data.db.cassandra.repo;

import com.example.data.model.entity.Pet;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetCassandraRepo extends CassandraRepository<Pet, Long> {

}
