package com.reynolds.safeguard.shared.config;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class DotenvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    /**
     * @param applicationContext
     */
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {


        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        Map<String, Object> props = new HashMap<>();

        dotenv.entries().forEach(entry -> props.put(entry.getKey(), entry.getValue()));

        applicationContext.getEnvironment().getPropertySources()
                .addLast(new MapPropertySource("dotenv", props));


    }
}
