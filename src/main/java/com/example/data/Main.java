package com.example.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


@EnableJpaRepositories(basePackages = {"com.example.data.db.postgres.repo"})
@EnableCassandraRepositories(basePackages = {"com.example.data.db.cassandra.repo"})
@EnableRedisRepositories(basePackages = {"com.example.data.db.redis.repo"})
@EnableNeo4jRepositories(basePackages = {"com.example.data.db.neo4j.repo"})
@EnableMongoRepositories(basePackages = {"com.example.data.db.mongo.repo"})
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
