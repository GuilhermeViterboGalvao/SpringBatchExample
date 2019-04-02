package br.com.example.springbatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("br.com.example.springbatch.repository.mysql")
public class MySqlConfiguration { }
