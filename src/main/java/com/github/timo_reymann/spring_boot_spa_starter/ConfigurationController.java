package com.github.timo_reymann.spring_boot_spa_starter;

import com.github.timo_reymann.spring_boot_spa_starter.configuration.SpaStarterConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * This controller provides the configuration you specified to spring
 *
 * @author timrey
 * @since 26.04.19
 */
@RestController
@RequestMapping("/${frontend.configuration-endpoint:configuration}")
public class ConfigurationController {
    private final HashMap<String, Object> configuration;

    public ConfigurationController(SpaStarterConfigurationProperties spaStarterConfigurationProperties) {
        this.configuration = new HashMap<>(spaStarterConfigurationProperties.getConfiguration());
    }

    @GetMapping
    public Map<String, Object> getConfiguration() {
        return configuration;
    }
}
