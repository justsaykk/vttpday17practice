package boardgame.games.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardgame.games.repository.BoardGameRepository;

@Service
public class BoardGameService {

    @Autowired
    private BoardGameRepository bgRepo;

    private String payload;

    public String getGame(String id) {
        Optional opt = bgRepo.getRecord(id);

        if (opt.isEmpty()) {
            String error = "id <%s> Game not found".formatted(id);
            return error;
        } else {
            payload = opt.get().toString();
            return payload;
        }
    }

    public List<String> getList(String offset, String limit) {
        List<String> payload = bgRepo.getList(offset, limit);
        return payload;
    }
}
