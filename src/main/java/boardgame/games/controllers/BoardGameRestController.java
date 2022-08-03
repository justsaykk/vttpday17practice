package boardgame.games.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boardgame.games.services.BoardGameService;
import jakarta.json.Json;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path = "/boardgame")
public class BoardGameRestController {

    @Autowired
    private BoardGameService bgSvc;

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGameJson(@PathVariable String id) {

        // Get the Svc to do the work & get result
        String resultSvc = bgSvc.getGame(id);

        // Build response body
        JsonObject resp = Json.createObjectBuilder()
                .add("game", resultSvc)
                .build();
        return ResponseEntity.ok(resp.toString());
    }

}
