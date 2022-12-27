package com.example.data.db.postgres.repo;

import com.example.data.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPostgresRepo extends JpaRepository<Person, Long> {
}
