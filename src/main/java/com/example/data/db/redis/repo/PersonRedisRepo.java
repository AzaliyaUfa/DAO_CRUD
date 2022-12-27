package com.example.data.db.redis.repo;

import com.example.data.model.entity.Person;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRedisRepo extends KeyValueRepository<Person, Long> {
}
