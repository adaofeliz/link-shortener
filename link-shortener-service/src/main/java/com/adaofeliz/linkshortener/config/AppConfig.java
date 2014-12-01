package com.adaofeliz.linkshortener.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("com.adaofeliz")
@EnableAutoConfiguration
public class AppConfig {
}
