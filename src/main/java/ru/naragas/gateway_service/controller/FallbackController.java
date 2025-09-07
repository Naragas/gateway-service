package ru.naragas.gateway_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Naragas
 * @version 1.0
 * @created 9/7/2025
 */

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/user")
    public ResponseEntity<Map<String, Object>> userServiceFallback() {
        return ResponseEntity.status(503)
                             .body(Map.of("service", "user-service",
                                     "status", "503",
                                     "message", "user-service temporarily unavailable"));
    }

    @GetMapping("/notification")
    public ResponseEntity<Map<String, Object>> notificationServiceFallback() {
        return ResponseEntity.status(503)
                .body(Map.of("service", "notification-service",
                        "status", "503",
                        "message", "notification-service temporarily unavailable"));
    }

}
