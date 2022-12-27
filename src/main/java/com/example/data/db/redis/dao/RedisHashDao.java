package com.example.data.db.redis.dao;

import com.example.data.general.dao.AbstractDao;
import com.example.data.model.AbstractEntity;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisHashDao<T extends AbstractEntity, I> extends AbstractDao<T, I> {

    private final HashOperations<String, Long, T> hashOperations;

    public RedisHashDao(RedisTemplate<String, T> redisTemplate,
                        Class<T> clazz) {
        super(clazz);
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public T create(T t) {
        hashOperations.put(clazz.getSimpleName(), t.getId(), t);
        return t;
    }

    @Override
    public T read(I id) {
        return hashOperations.get(clazz.getSimpleName(), id);
    }

    @Override
    public T update(T t) {
        hashOperations.put(clazz.getSimpleName(), t.getId(), t);
        return t;
    }

    @Override
    public boolean delete(I id) {
        Long i = hashOperations.delete(clazz.getSimpleName(), id);
        return !i.equals(0L);
    }

}
