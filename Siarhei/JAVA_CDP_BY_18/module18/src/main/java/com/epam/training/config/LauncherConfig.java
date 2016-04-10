package com.epam.training.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({InitializerConfig.class, RepositoryConfig.class, ServiceConfig.class})
public class LauncherConfig {

}
