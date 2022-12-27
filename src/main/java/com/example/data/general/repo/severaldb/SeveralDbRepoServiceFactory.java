package com.example.data.general.repo.severaldb;

import com.example.data.model.AbstractEntity;
import org.springframework.stereotype.Component;

@Component
public class SeveralDbRepoServiceFactory {

    public <T extends AbstractEntity, I> SeveralDbRepoService<T, I> getSeveralDbRepoService(Class<T> clazz,
                                                                                            SpringDataRepoFactory repoFactory) {
        return new SeveralDbRepoService<>(clazz, repoFactory);
    }
}
