package ru.nsk.positiveteam.vkcode.core.config.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("ru.nsk.positiveteam.vkcode.core.data.repo")
public class MyBatisConfig {
}
