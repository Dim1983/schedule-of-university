package com.loktionov.university.dao.impl;

import com.loktionov.university.dao.CourseDao;
import com.loktionov.university.entity.Course;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseCrudDaoImpl extends AbstractCrudDaoImpl<Course> implements CourseDao {
    private static final String SAVE_QUERY = "INSERT INTO course(name) values(:name)";
    private static final String DELETE_QUERY = "DELETE FROM course WHERE id = :id";
    private static final String UPDATE_QUERY = "UPDATE course SET name =:name WHERE id = :id";
    private static final String FIND_ALL_QUERY = "SELECT * FROM course";
    private static final String FIND_QUERY = "SELECT * FROM course WHERE id = :id";
    private static final RowMapper<Course> ROW_MAPPER = (resultSet, i) ->
            Course.builder().
                    withName(resultSet.getString("name")).
                    withId(resultSet.getInt("id")).
                    build();

    public CourseCrudDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(namedParameterJdbcTemplate, SAVE_QUERY, DELETE_QUERY, UPDATE_QUERY, FIND_ALL_QUERY, FIND_QUERY, ROW_MAPPER);
    }

    @Override
    public void insert(MapSqlParameterSource parameters, Course course) {
        parameters.addValue("id", course.getId());
        parameters.addValue("name", course.getName());
    }
}
