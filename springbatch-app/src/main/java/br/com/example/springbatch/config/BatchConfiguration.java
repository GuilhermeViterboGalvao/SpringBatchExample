package br.com.example.springbatch.config;

import br.com.example.springbatch.listener.JobCompletionNotificationListener;
import br.com.example.springbatch.model.mongodb.ContactDocument;
import br.com.example.springbatch.model.mysql.ContactTable;
import br.com.example.springbatch.processors.ContactItemProcessor;
import br.com.example.springbatch.processors.MySqlRowMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public ContactItemProcessor processor() {
        return new ContactItemProcessor();
    }

    @Bean
    public ItemReader<ContactTable> mysqlItemReader(DataSource dataSource) {
        JdbcCursorItemReader<ContactTable> mysqlItemReader = new JdbcCursorItemReader<>();
        mysqlItemReader.setRowMapper(new MySqlRowMapper());
        mysqlItemReader.setDataSource(dataSource);
        mysqlItemReader.setSql("select * from contact order by id;");
        return mysqlItemReader;
    }

    @Bean
    public ItemWriter<ContactDocument> mongoItemWriter(MongoTemplate mongoTemplate) {
        MongoItemWriter<ContactDocument> mongoItemWriter = new MongoItemWriter<>();
        mongoItemWriter.setTemplate(mongoTemplate);
        mongoItemWriter.setCollection("contacts");
        return mongoItemWriter;
    }

    @Bean
    public Step step1(ItemReader<ContactTable> mysqlItemReader, ItemWriter<ContactDocument> mongoItemWriter) {
        return stepBuilderFactory.get("step1")
                .<ContactTable, ContactDocument> chunk(10)
                .reader(mysqlItemReader)
                .processor(processor())
                .writer(mongoItemWriter)
                .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("mysql_contacts_to_mongodb")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }
}