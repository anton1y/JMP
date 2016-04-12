package jmp.spring.core.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "jmp.spring.core.services" })
public class ServiceConfig {
}
