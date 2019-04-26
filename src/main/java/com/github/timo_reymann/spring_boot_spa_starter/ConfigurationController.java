package com.github.timo_reymann.spring_boot_spa_starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author timrey
 * @since 26.04.19
 */
@RestController
@RequestMapping("/${frontend.configuration-endpoint:configuration}")
public class ConfigurationController {
    private final HashMap<String, String> configuration;

    public ConfigurationController(SpaStarterConfigurationProperties spaStarterConfigurationProperties) {
        HashMap<String, String> copy = new HashMap<>();
        copy.putAll(spaStarterConfigurationProperties.getConfiguration());
        this.configuration = copy;
    }

    @GetMapping
    public Map<String, String> getConfiguration() {
        return configuration;
    }
}
