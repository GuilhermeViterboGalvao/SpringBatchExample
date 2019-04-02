package br.com.example.springbatch.processors;

import br.com.example.springbatch.model.mysql.ContactTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class MySqlRowMapper implements RowMapper<ContactTable> {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String CREATED_AT = "createdAt";
    private static final String LAST_MODIFIED = "lastModified";

    @Override
    public ContactTable mapRow(ResultSet resultSet, int i) throws SQLException {
        ContactTable contactTable = ContactTable
                .builder()
                .id(resultSet.getLong(ID))
                .name(resultSet.getString(NAME))
                .lastName(resultSet.getString(LAST_NAME))
                .email(resultSet.getString(EMAIL))
                .createdAt(resultSet.getDate(CREATED_AT))
                .lastModified(resultSet.getDate(LAST_MODIFIED))
                .build();
        log.info("Reading record contactTable=" + contactTable.toString());
        return contactTable;
    }
}
