package com.example.data.db.redis.dao;


import com.example.data.general.dao.AbstractDao;
import com.example.data.general.dao.AbstractDaoFactory;
import com.example.data.model.AbstractEntity;
//import com.example.data.util.DBFactoryType;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component//(DBFactoryType.BeanNames.REDIS_DAO)
@ConditionalOnProperty(name = "redis.db.enabled", havingValue = "true")
@NoArgsConstructor
public class RedisDaoFactory implements AbstractDaoFactory {

    @Override
    public <T extends AbstractEntity, I> AbstractDao<T, I> getDao(Class<T> clazz) {
        return new RedisHashDao<>(redisTemplate(redisConnectionFactory()), clazz);
    }

    private LettuceConnectionFactory redisConnectionFactory() {
        LettuceConnectionFactory lcf = new LettuceConnectionFactory();
        lcf.afterPropertiesSet();
        return lcf;
    }

    private <T> RedisTemplate<String, T> redisTemplate(LettuceConnectionFactory lcf) {
        RedisTemplate<String, T> template = new RedisTemplate<>();
        template.setConnectionFactory(lcf);
        template.setHashKeySerializer(RedisSerializer.json());
        template.setKeySerializer(RedisSerializer.string());
        template.setHashValueSerializer(RedisSerializer.json());
        template.afterPropertiesSet();
        return template;
    }
}
