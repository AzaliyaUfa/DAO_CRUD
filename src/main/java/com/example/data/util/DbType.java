package com.example.data.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum DbType {

    POSTGRES("postgres", 1),
    REDIS("redis", 2),
    CASSANDRA("cassandra", 3),
    NEO4J("neo4j", 4),
    MONGODB("mongo", 5);

    private final String dbName;

    private final Integer dbNum;

    public static DbType getByDbName(String dbName) {
        return Arrays.stream(DbType.values())
                .filter(ft -> ft.dbName.equals(dbName))
                .findFirst().orElseThrow(() -> new RuntimeException("Неверный тип"));
    }

    public static DbType getByDbNum(Integer dbNum) {
        return Arrays.stream(DbType.values())
                .filter(ft -> ft.dbNum.equals(dbNum))
                .findFirst().orElseThrow(() -> new RuntimeException("Неверный тип"));
    }
}
