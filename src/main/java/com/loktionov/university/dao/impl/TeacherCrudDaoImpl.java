package com.loktionov.university.dao.impl;

import com.loktionov.university.dao.TeacherDao;
import com.loktionov.university.entity.Phone;
import com.loktionov.university.entity.Teacher;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherCrudDaoImpl extends AbstractCrudDaoImpl<Teacher> implements TeacherDao {
    private static final String SAVE_QUERY = "INSERT INTO teacher(name,secondName, birthday, phoneid, email, password, rank)" +
            " values(:name, :secondName,TO_DATE(:birthday, 'yyyy-mm-dd'),:phoneid ,:email ,:password, :rank)";
    private static final String DELETE_QUERY = "DELETE FROM teacher WHERE id = :id";
    private static final String UPDATE_QUERY = "UPDATE teacher SET name = :name ,secondname =:secondName, " +
            "birthday = :birthday, phoneid = :id, email = :email, password =:password, rank =:rank  WHERE id = :id";
    private static final String FIND_ALL_QUERY = "SELECT teacher.id, teacher.name, teacher.secondName, teacher.birthday, " +
            "teacher.phoneid, teacher.email, teacher.password, teacher.rank, phone.id, phone.codeofcountry, " +
            "phone.codeofcity, phone.phonenumber, phone.additionalnumber  FROM teacher JOIN phone ON teacher.phoneid=phone.id;";
    private static final String FIND_QUERY = "SELECT teacher.id, teacher.name, teacher.secondName, teacher.birthday," +
            " teacher.phoneid, teacher.email, teacher.password, teacher.rank, phone.id, phone.codeofcountry, " +
            "phone.codeofcity, phone.phonenumber, phone.additionalnumber  FROM teacher  " +
            "JOIN phone ON teacher.phoneid=phone.id WHERE teacher.id =:id;";
    private static final RowMapper<Teacher> ROW_MAPPER = (resultSet, i) -> Teacher.builder()
            .withId(resultSet.getInt("id"))
            .withName(resultSet.getString("name"))
            .withSecondName(resultSet.getString("secondname"))
            .withBirthday(resultSet.getDate("birthday").toLocalDate())
            .withPhone(new Phone(resultSet.getInt(1), resultSet.getString("codeofcountry"),
                    resultSet.getString("codeofcity"),
                    resultSet.getString("phonenumber"),
                    resultSet.getString("additionalnumber")))
            .withEmail(resultSet.getString("email"))
            .withPassword(resultSet.getString("password"))
            .withRank(resultSet.getString("rank"))
            .build();

    public TeacherCrudDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(namedParameterJdbcTemplate, SAVE_QUERY, DELETE_QUERY, UPDATE_QUERY, FIND_ALL_QUERY, FIND_QUERY, ROW_MAPPER);
    }

    @Override
    public void insert(MapSqlParameterSource parameters, Teacher teacher) {
        parameters.addValue("id", teacher.getId());
        parameters.addValue("name", teacher.getId());
        parameters.addValue("secondName", teacher.getSecondName());
        parameters.addValue("birthday", teacher.getBirthday());
        parameters.addValue("phoneid", teacher.getPhone().getId());
        parameters.addValue("email", teacher.getEmail());
        parameters.addValue("password", teacher.getPassword());
        parameters.addValue("rank", teacher.getRank());
    }
}
