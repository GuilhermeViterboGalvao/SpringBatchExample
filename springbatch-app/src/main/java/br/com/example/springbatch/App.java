package br.com.example.springbatch;

import br.com.example.springbatch.config.AppConfiguration;
import br.com.example.springbatch.config.BatchConfiguration;
import br.com.example.springbatch.config.MongoConfiguration;
import br.com.example.springbatch.config.MySqlConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        new SpringApplicationBuilder(
            App.class,
            AppConfiguration.class,
            MongoConfiguration.class,
            MySqlConfiguration.class,
            BatchConfiguration.class
        ).run(args);
    }
}
