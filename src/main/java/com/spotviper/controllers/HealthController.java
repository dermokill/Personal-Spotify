package com.spotviper.controllers;

import java.time.Instant;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Lightweight liveness endpoint for quick manual sanity checks during development.
 *
 * <p>Operational health/readiness is served by Spring Boot Actuator at
 * {@code /actuator/health}; this simply confirms the web layer is up.
 */
@RestController
@RequestMapping("/api")
public class HealthController {

    private final String applicationName;

    public HealthController(@Value("${spring.application.name}") String applicationName) {
        this.applicationName = applicationName;
    }

    @GetMapping("/ping")
    public Map<String, Object> ping() {
        return Map.of(
                "app", applicationName,
                "status", "UP",
                "timestamp", Instant.now().toString());
    }
}
