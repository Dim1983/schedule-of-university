package com.loktionov.university.dao;

import com.loktionov.university.dao.impl.DepartmentCrudDaoImpl;
import com.loktionov.university.entity.Course;
import com.loktionov.university.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class DepartmentCrudDaoImplTest extends AbstractDaoTest {
    private DepartmentCrudDaoImpl departmentCrudDaoImplTest;

    @BeforeEach
    void init() {
        super.init();

        departmentCrudDaoImplTest = new DepartmentCrudDaoImpl(namedParameterJdbcTemplate);
    }

    @Test
    void saveShouldBeInsertDataOfTableDepartment() {
        Department expected = Department.builder()
                .withId(5)
                .withName("Five")
                .build();
        departmentCrudDaoImplTest.save(expected);

        assertThat(departmentCrudDaoImplTest.findById(5).get(), equalTo(expected));
    }

    @Test
    void updateShouldBeUpdateDataOfTableDepartment() {
        Department expected = Department.builder()
                .withId(1)
                .withName("New name")
                .build();
        departmentCrudDaoImplTest.update(expected);

        assertThat(departmentCrudDaoImplTest.findById(1).get(), equalTo(expected));
    }

    @Test
    void deleteByIdShouldBeDeletedDataOfTableDepartment() {
        departmentCrudDaoImplTest.deleteById(3);
        Optional<Course> expected = Optional.empty();

        assertThat(departmentCrudDaoImplTest.findById(3), is(expected));
    }

    @Test
    void findByIdShouldBeReturnDepartment() {
        Department expected = Department.builder()
                .withId(1)
                .withName("New name")
                .build();
        departmentCrudDaoImplTest.save(expected);

        assertThat(departmentCrudDaoImplTest.findById(1).get(), equalTo(expected));
    }

    @Test
    void findAllEntityShouldBeReturnDepartments() {
        List<Department> expected = Arrays.asList(
                Department.builder().withId(1).withName("One").build(),
                Department.builder().withId(2).withName("Two").build(),
                Department.builder().withId(3).withName("Three").build(),
                Department.builder().withId(4).withName("Four").build()
        );

        assertThat(departmentCrudDaoImplTest.findAll(10), is(expected));
    }
}
