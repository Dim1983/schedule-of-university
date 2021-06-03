package com.loktionov.university.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

class AbstractDaoTest {
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    void init() {
        EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
                .setName("testdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL;")
                .setType(H2)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();

        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(embeddedDatabase);
    }
}
