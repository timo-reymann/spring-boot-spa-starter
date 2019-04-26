package com.github.timo_reymann.spring_boot_spa_starter;

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
@Configuration
@Slf4j
public class WebMvConfiguration implements WebMvcConfigurer {
    private final ResourceProperties resourceProperties;
    private final static String[] ASSET_PATTERNS = {
            "/**/*.css",
            "/**/*.html",
            "/**/*.js",
            "/**/*.jsx",
            "/**/*.png",
            "/**/*.jpg",
            "/**/*.ico",
            "/**/*.ttf",
            "/**/*.woff",
            "/**/*.woff2",
            "/**/*.pdf",
            "/**/*.map"
    };

    public WebMvConfiguration(ResourceProperties resourceProperties) {
        this.resourceProperties = resourceProperties;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        log.info("Registering resource handler for spa ...");

        registry.addResourceHandler(ASSET_PATTERNS)
                .addResourceLocations(resourceProperties.getStaticLocations())
                .resourceChain(resourceProperties.getChain().isCache())
                .addResolver(new PathResourceResolver() {
                    @Override
                    public Resource resolveResource(HttpServletRequest request, String requestPath, List<? extends Resource> locations, ResourceResolverChain chain) {
                        final Resource resource = super.resolveResource(request, requestPath, locations, chain);
                        if (resource != null) {
                            return resource;
                        } else {
                            return super.resolveResource(request, "/index.html", locations, chain);
                        }
                    }
                });
    }
}
