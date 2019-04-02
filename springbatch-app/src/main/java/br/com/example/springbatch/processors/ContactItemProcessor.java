package br.com.example.springbatch.processors;

import br.com.example.springbatch.model.mongodb.ContactDocument;
import br.com.example.springbatch.model.mysql.ContactTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class ContactItemProcessor implements ItemProcessor<ContactTable, ContactDocument> {

    @Override
    public ContactDocument process(ContactTable contactTable) throws Exception {
        if (contactTable != null) {
            ContactDocument contactDocument = ContactDocument
                    .builder()
                    .id(contactTable.getId())
                    .name(contactTable.getName() + " " + contactTable.getLastName())
                    .email(contactTable.getEmail())
                    .password(contactTable.getPassword())
                    .createdAt(contactTable.getCreatedAt())
                    .lastModified(contactTable.getLastModified())
                    .build();
            log.info("Transformin contactTable=" + contactTable.toString() + " in contactDocument=" + contactDocument.toString());
            return contactDocument;
        }
        return null;
    }
}