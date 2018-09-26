package com.test.sql.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.test.sql.model.entity")
@EnableJpaRepositories("com.test.sql.model.repository")
public class DbConfig {
}
