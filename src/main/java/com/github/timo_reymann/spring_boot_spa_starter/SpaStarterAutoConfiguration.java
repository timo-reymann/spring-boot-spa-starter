package com.github.timo_reymann.spring_boot_spa_starter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author timrey
 * @since 26.04.19
 */
@Import(value = {
        SpaStarterConfigurationProperties.class,
        ConfigurationController.class
})
public class SpaStarterAutoConfiguration {
}
