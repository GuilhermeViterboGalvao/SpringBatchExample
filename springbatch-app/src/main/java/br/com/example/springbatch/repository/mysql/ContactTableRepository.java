package br.com.example.springbatch.repository.mysql;

import br.com.example.springbatch.model.mysql.ContactTable;
import org.springframework.data.repository.CrudRepository;

public interface ContactTableRepository extends CrudRepository<ContactTable, Long> { }
