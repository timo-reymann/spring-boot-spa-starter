package com.github.timo_reymann.spring_boot_spa_starter.test;

import com.github.timo_reymann.spring_boot_spa_starter.SpaStarterAutoConfiguration;
import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ConfigurationControllerTest {
    private WebApplicationContextRunner contextRunner = new WebApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(SpaStarterAutoConfiguration.class, WebMvcAutoConfiguration.class, MockMvcAutoConfiguration.class));

    @Test
    public void testAutoConfigurationIsWorking() {
        this.contextRunner.run((context) -> {
            assertThat(context).hasSingleBean(SpaStarterAutoConfiguration.class);
        });
    }

    @Test
    public void testConfigurationControllerIsResponding() {
        this.contextRunner
                .withPropertyValues("frontend.configuration.someNumber=1")
                .run(context -> {
                    MockMvc mockMvc = context.getBean(MockMvc.class);
                    mockMvc.perform(get("/configuration"))
                            .andExpect(status().isOk())
                            .andExpect(jsonPath("$.someNumber", is("1")));
                });
    }
}
