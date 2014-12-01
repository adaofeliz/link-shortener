package com.adaofeliz.linkshortener;

import com.adaofeliz.linkshortener.config.AppConfig;
import org.springframework.boot.SpringApplication;

public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppConfig.class, args);
    }

}
