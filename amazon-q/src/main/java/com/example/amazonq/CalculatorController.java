package com.example.amazonq;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculatorController {

    @Autowired
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public ResponseEntity<Map<String, Integer>> add(@RequestParam("first") int first, @RequestParam("second") int second) {
        Map<String, Integer> response = new HashMap<>();
        response.put("answer", service.add(first, second));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/subtract")
    public ResponseEntity<Map<String, Integer>> subtract(@RequestParam("first") int first, @RequestParam("second") int second) {
        Map<String, Integer> response = new HashMap<>();
        response.put("answer", service.subtract(first, second));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/multiply")
    public ResponseEntity<Map<String, Integer>> multiply(@RequestParam("first") int first, @RequestParam("second") int second) {
        Map<String, Integer> response = new HashMap<>();
        response.put("answer", service.multiply(first, second));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/divide")
    public ResponseEntity<Map<String, Integer>> divide(@RequestParam("first") int first, @RequestParam("second") int second) {
        Map<String, Integer> response = new HashMap<>();
        response.put("answer", service.divide(first, second));
        return ResponseEntity.ok(response);
    }

}

