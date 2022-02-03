package org.perscholas.practicetracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.perscholas.practicetracker.database")
public class DatabaseConfig {
}
