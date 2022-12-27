package com.example.data.model.entity;

import com.example.data.model.AbstractEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // аннотация для PostgreSQL
@RedisHash("Pet") // аннотация для Redis
@Table // аннотация для Cassandra
@Node() // аннотация для Neo4j
@Document(collection = "mongodbPerson") // аннотация для MongoDB
public class Pet extends AbstractEntity {

    @ApiModelProperty(value = "имя", example = "Rex")
    private String name;

    @ApiModelProperty(value = "имя", example = "dog")
    private String type;

}

