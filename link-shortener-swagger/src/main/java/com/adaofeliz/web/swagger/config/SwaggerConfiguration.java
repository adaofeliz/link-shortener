package com.adaofeliz.web.swagger.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Configuration
@EnableSwagger
public class SwaggerConfiguration {

    @Resource
    private SpringSwaggerConfig springSwaggerConfig;

    @Value("${app.name:Application Name - Property app.name}")
    private String appName;

    @Value("${app.description:Application Description - Property app.description}")
    private String appDescription;

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                appName, // Application name
                appDescription, // Application description
                null, // API TOS
                null, // Email Contact
                null, // API License
                null // API License URL
        );
        return apiInfo;
    }

}