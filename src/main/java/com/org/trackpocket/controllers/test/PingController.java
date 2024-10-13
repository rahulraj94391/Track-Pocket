package com.org.trackpocket.controllers.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PingController {
    @GetMapping(value = {"/", "/ping", "status"})
    public ResponseEntity<HashMap<String, String>> ping() {
        HashMap<String, String> response = new HashMap<>();
        response.put("connection", "alive");
        return ResponseEntity.ok(response);
    }
}
