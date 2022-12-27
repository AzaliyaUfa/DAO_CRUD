package com.example.data.db.redis.repo;

import com.example.data.model.entity.Pet;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRedisRepo extends KeyValueRepository<Pet, Long> {
}
