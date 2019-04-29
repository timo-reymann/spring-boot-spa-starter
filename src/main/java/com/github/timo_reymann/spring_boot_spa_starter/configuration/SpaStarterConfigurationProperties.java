package com.github.timo_reymann.spring_boot_spa_starter.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration Properties for spring-boot-spa-starter
 *
 * @author Timo Reymann
 * @since 26.04.19
 */
@Configuration("SpaStarterConfiguration")
@ConfigurationProperties("frontend")
@EnableConfigurationProperties
@Data
public class SpaStarterConfigurationProperties {
    /**
     * Configuration options provided via endpoint, this one is provided from the controller as it is, without
     * converting the case or doing any magic on the nested properties. So e. g. you want to provide the Rest-URL under
     * the property restUrl via json, simply specify it like <i>frontend.configuration.restUrl=http://mycoolrest.api</i>
     */
    private Map<String, Object> configuration = new HashMap<>();

    /**
     * Endpoint for configuration, specify it if you want to customize the configuration endpoint, default <i>/configuration</i>
     */
    private String configurationEndpoint;

    /**
     * This provides the value for {@link ResourceHandlerRegistration#setCachePeriod(Integer)}
     * <br />
     * For more information look over there.
     */
    private Integer cachePeriod = 0;
}
