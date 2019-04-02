package br.com.example.springbatch.repository.mongodb;

import br.com.example.springbatch.model.mongodb.ContactDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactDocumentRepository extends MongoRepository<ContactDocument, String> { }