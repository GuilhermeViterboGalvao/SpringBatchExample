package br.com.example.springbatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("br.com.example.springbatch.repository.mongodb")
public class MongoConfiguration { }
