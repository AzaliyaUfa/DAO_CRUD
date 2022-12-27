package com.example.data.db.postgres.repo;

import com.example.data.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetPostgresRepo extends JpaRepository<Pet, Long> {
}
