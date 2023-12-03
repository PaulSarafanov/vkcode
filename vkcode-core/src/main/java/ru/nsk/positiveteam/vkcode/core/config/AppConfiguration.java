package ru.nsk.positiveteam.vkcode.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "ru.nsk.positiveteam.vkcode")
public class AppConfiguration {
}
