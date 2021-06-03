package com.loktionov.university.dao.impl;

import com.loktionov.university.dao.DepartmentDao;
import com.loktionov.university.entity.Department;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentCrudDaoImpl extends AbstractCrudDaoImpl<Department> implements DepartmentDao {
    private static final String SAVE_QUERY = "INSERT INTO department(name) values(:name)";
    private static final String DELETE_QUERY = "DELETE FROM department WHERE id = :id";
    private static final String UPDATE_QUERY = "UPDATE department SET name =:name WHERE id = :id";
    private static final String FIND_ALL_QUERY = "SELECT * FROM department";
    private static final String FIND_QUERY = "SELECT * FROM department WHERE id = :id";
    private static final RowMapper<Department> ROW_MAPPER = (resultSet, i) ->
            Department.builder().
                    withId(resultSet.getInt("id")).
                    withName(resultSet.getString("name")).
                    build();

    public DepartmentCrudDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(namedParameterJdbcTemplate, SAVE_QUERY, DELETE_QUERY, UPDATE_QUERY, FIND_ALL_QUERY, FIND_QUERY, ROW_MAPPER);
    }

    @Override
    public void insert(MapSqlParameterSource parameters, Department department) {
        parameters.addValue("id", department.getId());
        parameters.addValue("name", department.getName());
    }
}
