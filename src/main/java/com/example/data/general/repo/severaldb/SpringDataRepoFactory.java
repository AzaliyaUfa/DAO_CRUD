package com.example.data.general.repo.severaldb;

import com.example.data.model.AbstractEntity;
import com.example.data.util.DbType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SpringDataRepoFactory {

    private final Map<String, CrudRepository> repoMap;

    public SpringDataRepoFactory(Map<String, CrudRepository> repoMap) {
        this.repoMap = repoMap.entrySet()
        .stream()
        .collect(Collectors.toMap(r -> r.getKey().toLowerCase(), Map.Entry::getValue));
    }

    public <T extends AbstractEntity, I> CrudRepository<T, I> getRepo(Class<T> clazz, DbType dbType) {
        return repoMap.get(clazz.getSimpleName().toLowerCase() + dbType.getDbName() + "repo");
    }
}
