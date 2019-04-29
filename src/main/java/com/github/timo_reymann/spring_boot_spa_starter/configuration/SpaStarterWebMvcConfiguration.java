package com.github.timo_reymann.spring_boot_spa_starter.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * WebMvc-Configuration for serving frontend files and doing index rewrite
 *
 * @author Timo Reymann
 * @since 26.04.19
 */
@Configuration("SpaStarterWebMvcConfiguration")
@Slf4j
public class SpaStarterWebMvcConfiguration implements WebMvcConfigurer {
    private final ResourceProperties resourceProperties;
    private final SpaStarterConfigurationProperties spaStarterConfigurationProperties;

    public SpaStarterWebMvcConfiguration(ResourceProperties resourceProperties,
                                         SpaStarterConfigurationProperties spaStarterConfigurationProperties) {
        this.resourceProperties = resourceProperties;
        this.spaStarterConfigurationProperties = spaStarterConfigurationProperties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations(resourceProperties.getStaticLocations())
                .setCachePeriod(spaStarterConfigurationProperties.getCachePeriod())
                .resourceChain(resourceProperties.getChain().isCache())
                .addResolver(new PathResourceResolver() {
                    @Override
                    public Resource resolveResource(HttpServletRequest request, String requestPath, List<? extends Resource> locations, ResourceResolverChain chain) {
                        final Resource resource = super.resolveResource(request, requestPath, locations, chain);
                        return resource != null ? resource : super.resolveResource(request, "/index.html", locations, chain);
                    }
                });
    }
}
