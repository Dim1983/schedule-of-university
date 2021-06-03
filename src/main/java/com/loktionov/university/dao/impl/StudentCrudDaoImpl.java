package com.loktionov.university.dao.impl;

import com.loktionov.university.dao.StudentDao;
import com.loktionov.university.entity.Phone;
import com.loktionov.university.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentCrudDaoImpl extends AbstractCrudDaoImpl<Student> implements StudentDao {
    private static final String SAVE_QUERY = "INSERT INTO student(name,secondName, birthday, phoneid, email, password, status)" +
            " values(:name, :secondName,TO_DATE(:birthday, 'yyyy-mm-dd'),:phoneid ,:email ,:password, :status)";
    private static final String DELETE_QUERY = "DELETE FROM student WHERE id = :id";
    private static final String UPDATE_QUERY = "UPDATE student SET name = :name ,secondname =:secondName," +
            " birthday = :birthday, phoneid = :id, email = :email, password =:password, status =:status  WHERE id = :id";
    private static final String FIND_ALL_QUERY = "SELECT student.id, student.name, student.secondName, student.birthday," +
            "student.phoneid, student.email, student.password, student.status, phone.id, phone.codeofcountry," +
            "phone.codeofcity, phone.phonenumber, phone.additionalnumber  FROM student JOIN phone ON student.phoneid=phone.id;";
    private static final String FIND_QUERY = "SELECT student.id, student.name, student.secondName, student.birthday, " +
            "student.phoneid, student.email, student.password, student.status, phone.id, phone.codeofcountry, " +
            "phone.codeofcity, phone.phonenumber, phone.additionalnumber  FROM student " +
            "JOIN phone ON student.phoneid=phone.id WHERE student.id =:id;";
    private static final RowMapper<Student> ROW_MAPPER = (resultSet, i) -> Student.builder()
            .withId(resultSet.getInt("id"))
            .withName(resultSet.getString("name"))
            .withSecondName(resultSet.getString("secondName"))
            .withBirthday(resultSet.getDate("birthday").toLocalDate())
            .withPassword(resultSet.getString("password"))
            .withPhone(new Phone(resultSet.getInt("phoneid"),
                    resultSet.getString("codeofcountry"),
                    resultSet.getString("codeofcity"),
                    resultSet.getString("phonenumber"),
                    resultSet.getString("additionalnumber")
            ))
            .withEmail(resultSet.getString("email"))
            .withStatus(resultSet.getString("status"))
            .build();

    @Autowired
    public StudentCrudDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(namedParameterJdbcTemplate, SAVE_QUERY, DELETE_QUERY, UPDATE_QUERY, FIND_ALL_QUERY, FIND_QUERY, ROW_MAPPER);
    }

    @Override
    public void insert(MapSqlParameterSource parameters, Student student) {
        parameters.addValue("id", student.getId());
        parameters.addValue("name", student.getName());
        parameters.addValue("secondName", student.getSecondName());
        parameters.addValue("birthday", student.getBirthday());
        parameters.addValue("phoneid", student.getPhone().getId());
        parameters.addValue("email", student.getEmail());
        parameters.addValue("password", student.getPassword());
        parameters.addValue("status", student.getStatus());
    }
}
