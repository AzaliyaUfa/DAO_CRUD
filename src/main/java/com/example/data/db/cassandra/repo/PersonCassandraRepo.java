package com.example.data.db.cassandra.repo;

import com.example.data.model.entity.Person;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCassandraRepo extends CassandraRepository<Person, Long> {

}
