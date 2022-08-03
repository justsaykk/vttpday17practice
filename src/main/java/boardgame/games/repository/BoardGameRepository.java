package boardgame.games.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class BoardGameRepository {

    @Autowired
    @Qualifier("repo")
    private RedisTemplate<String, String> redisTemplate;

    public Optional<String> getRecord(String id) {
        ValueOperations<String, String> Ops = redisTemplate.opsForValue();
        String value = Ops.get(id);

        if (null == value) {
            return Optional.empty();
        }
        return Optional.of(value);
    }

    public List<String> getList(String offset, String limit) {
        List<String> keyList = new LinkedList<>();
        ValueOperations<String, String> Ops = redisTemplate.opsForValue();
        Integer startingIndex = Integer.parseInt(offset) + 1;
        Integer endingIndex = startingIndex + Integer.parseInt(limit);

        for (int i = startingIndex; i < endingIndex; i++) {
            String value = Ops.get(Integer.toString(i));
            keyList.add(value);
        }

        return keyList;
    }
}
