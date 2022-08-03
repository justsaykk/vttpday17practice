package boardgame.games.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boardgame.games.services.BoardGameService;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path = "/boardgames")
public class BoardGamesRestController {

    @Autowired
    private BoardGameService bgSvc;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGameJson(
            @RequestParam(name = "offset", defaultValue = "0") String offset,
            @RequestParam(name = "limit", defaultValue = "5") String limit) {

        // Get the Svc to do the work & get result
        List<String> resultSvc = bgSvc.getList(offset, limit);

        // Build JSON array
        JsonArray jarrBuilder = Json.createArrayBuilder(resultSvc).build();

        // Build response body
        JsonObject resp = Json.createObjectBuilder()
                .add("game", jarrBuilder)
                .build();
        return ResponseEntity.ok(resp.toString());
    }
}
