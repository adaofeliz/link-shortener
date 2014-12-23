package com.adaofeliz.linkshortener.config;

import com.adaofeliz.web.swagger.SwaggerResources;
import com.mangofactory.swagger.plugin.EnableSwagger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created on 01/12/14.
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Static Resources Mapping
        registry.addResourceHandler("/web/*")
                .addResourceLocations("/web/")
                .setCachePeriod(0);

        // Static Resources Mapping
        registry.addResourceHandler(SwaggerResources.WEB_JAR_RESOURCE_PATTERN)
                .addResourceLocations(SwaggerResources.WEB_JAR_RESOURCE_LOCATION)
                .setCachePeriod(0);
    }

}
