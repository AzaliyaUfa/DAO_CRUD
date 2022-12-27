package com.example.data.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class AbstractEntity implements Serializable {

    @javax.persistence.Id // аннотация для PostgreSQL
    @org.springframework.data.annotation.Id // аннотация для Redis и MongoDB
    @PrimaryKey // аннотация для Cassandra
    @org.springframework.data.neo4j.core.schema.Id // аннотация для Neo4j
    private Long id;

}
