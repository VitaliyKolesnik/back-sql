package com.test.sql.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("com.test.sql.model.entity.*")

public class DbConfig {
}
