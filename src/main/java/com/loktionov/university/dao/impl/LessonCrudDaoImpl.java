package com.loktionov.university.dao.impl;

import com.loktionov.university.dao.LessonDao;
import com.loktionov.university.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LessonCrudDaoImpl extends AbstractCrudDaoImpl<Lesson> implements LessonDao {
    private static final String SAVE_QUERY = "INSERT INTO lesson(name) values(:name)";
    private static final String DELETE_QUERY = "DELETE FROM lesson WHERE id = :id";
    private static final String UPDATE_QUERY = "UPDATE lesson SET name =:name WHERE id = :id";
    private static final String FIND_ALL_QUERY = "SELECT * FROM lesson";
    private static final String FIND_QUERY = "SELECT * FROM lesson WHERE id = :id";
    private static final RowMapper<Lesson> ROW_MAPPER = (resultSet, i) -> new Lesson(resultSet.getInt("id"),
            resultSet.getString("name"));

    @Autowired
    public LessonCrudDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(namedParameterJdbcTemplate, SAVE_QUERY, DELETE_QUERY, UPDATE_QUERY, FIND_ALL_QUERY, FIND_QUERY, ROW_MAPPER);
    }

    @Override
    public void insert(MapSqlParameterSource parameters, Lesson lesson) {
        parameters.addValue("id", lesson.getId());
        parameters.addValue("name", lesson.getName());
    }
}
