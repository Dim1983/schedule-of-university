package com.loktionov.university.dao.impl;

import com.loktionov.university.dao.GroupDao;
import com.loktionov.university.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GroupCrudDaoImpl extends AbstractCrudDaoImpl<Group> implements GroupDao {
    private static final String SAVE_QUERY = "INSERT INTO groupes(name) values(:name)";
    private static final String DELETE_QUERY = "DELETE FROM groupes WHERE id = :id";
    private static final String UPDATE_QUERY = "UPDATE groupes SET name =:name WHERE id = :id";
    private static final String FIND_ALL_QUERY = "SELECT * FROM groupes";
    private static final String FIND_QUERY = "SELECT * FROM groupes WHERE id = :id";
    private static final RowMapper<Group> ROW_MAPPER = (resultSet, i) ->
            Group.builder().
                    withId(resultSet.getInt("id")).
                    withName(resultSet.getString("name")).
                    build();

    @Autowired
    public GroupCrudDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(namedParameterJdbcTemplate, SAVE_QUERY, DELETE_QUERY, UPDATE_QUERY, FIND_ALL_QUERY, FIND_QUERY, ROW_MAPPER);
    }

    @Override
    public void insert(MapSqlParameterSource parameters, Group group) {
        parameters.addValue("id", group.getId());
        parameters.addValue("name", group.getName());
    }
}
