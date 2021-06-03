package com.loktionov.university.dao.impl;

import com.loktionov.university.dao.AuditoryDao;
import com.loktionov.university.entity.Auditory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuditoryCrudDaoImpl extends AbstractCrudDaoImpl<Auditory> implements AuditoryDao {
    private static final String SAVE_QUERY = "INSERT INTO auditory(number) values(:number)";
    private static final String DELETE_QUERY = "DELETE FROM auditory WHERE id = :id";
    private static final String UPDATE_QUERY = "UPDATE auditory SET number =:number WHERE id =:id";
    private static final String FIND_ALL_QUERY = "SELECT * FROM auditory limit :limit offset :offset";
    private static final String FIND_QUERY = "SELECT * FROM auditory WHERE id = :id";
    private static final RowMapper<Auditory> ROW_MAPPER = (resultSet, i) -> new Auditory(resultSet.getInt("id"),
            resultSet.getInt("number"));

    public AuditoryCrudDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(namedParameterJdbcTemplate, SAVE_QUERY, DELETE_QUERY, UPDATE_QUERY, FIND_ALL_QUERY, FIND_QUERY, ROW_MAPPER);
    }

    @Override
    public void insert(MapSqlParameterSource parameters, Auditory auditory) {
        parameters.addValue("id", auditory.getId());
        parameters.addValue("number", auditory.getNumber());
    }
}
