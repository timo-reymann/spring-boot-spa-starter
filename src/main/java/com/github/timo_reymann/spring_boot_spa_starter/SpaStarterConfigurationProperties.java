package com.github.timo_reymann.spring_boot_spa_starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Timo Reymann
 * @since 26.04.19
 */
@Configuration
@ConfigurationProperties("frontend")
@EnableConfigurationProperties
@Data
public class SpaStarterConfigurationProperties {
    /**
     * Configuration options provided via endpoint
     */
    private Map<String, String> configuration = new HashMap<>();
    /**
     * Endpoint for configuration
     */
    private String configurationEndpoint;
}
