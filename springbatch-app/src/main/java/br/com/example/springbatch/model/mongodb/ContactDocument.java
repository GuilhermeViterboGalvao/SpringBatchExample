package br.com.example.springbatch.model.mongodb;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Document(collection = "contact")
public class ContactDocument {

    @Id
    private String _id;

    private Long id;

    private String name;

    private String email;

    private String password;

    private Date createdAt;

    private Date lastModified;
}
