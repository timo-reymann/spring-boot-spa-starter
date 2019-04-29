package com.github.timo_reymann.spring_boot_spa_starter.test;

import com.github.timo_reymann.spring_boot_spa_starter.SpaStarterAutoConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = {SpaStarterAutoConfiguration.class, WebMvcAutoConfiguration.class})
@RunWith(SpringRunner.class)
public class HtmlRewriteTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {

    }

    @Test
    public void indexHtmlMapping() throws Exception {
        mockMvc.perform(get("/sample"))
                .andExpect(status().isOk())
                .andExpect(content().string("This is some real cool web app!"));

        mockMvc.perform(get("/some/non/existing/path"))
                .andExpect(status().isOk())
                .andExpect(content().string("This is some real cool web app!"));
    }
}
