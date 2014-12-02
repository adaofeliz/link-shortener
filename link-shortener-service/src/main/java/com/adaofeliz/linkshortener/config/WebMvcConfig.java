package com.adaofeliz.linkshortener.config;

import com.adaofeliz.web.swagger.SwaggerResources;
import com.adaofeliz.web.versioning.ApiVersionRequestMappingHandlerMapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created on 01/12/14.
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new ApiVersionRequestMappingHandlerMapping();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Static Resources Mapping
        registry.addResourceHandler(SwaggerResources.WEB_JAR_RESOURCE_PATTERN)
                .addResourceLocations(SwaggerResources.WEB_JAR_RESOURCE_LOCATION)
                .setCachePeriod(0);
    }

}
