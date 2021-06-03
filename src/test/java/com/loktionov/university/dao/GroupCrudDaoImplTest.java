package com.loktionov.university.dao;

import com.loktionov.university.dao.impl.GroupCrudDaoImpl;
import com.loktionov.university.entity.Group;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class GroupCrudDaoImplTest extends AbstractDaoTest {
    private GroupCrudDaoImpl groupCrudDaoImplTest;

    @BeforeEach
    void init() {
        super.init();

        groupCrudDaoImplTest = new GroupCrudDaoImpl(namedParameterJdbcTemplate);
    }

    @Test
    void saveShouldBeInsertDataOfTableGroup() {
        Group expected = Group.builder()
                .withId(5)
                .withName("Five")
                .build();
        groupCrudDaoImplTest.save(expected);

        assertThat(groupCrudDaoImplTest.findById(5).get(), equalTo(expected));
    }

    @Test
    void updateShouldBeUpdateDataOfTableGroupes() {
        Group expected = Group.builder()
                .withId(4)
                .withName("New name")
                .build();
        groupCrudDaoImplTest.update(expected);

        assertThat(groupCrudDaoImplTest.findById(4).get(), equalTo(expected));
    }

    @Test
    void deleteByIdShouldBeDeletedDataOfTableGroups() {
        groupCrudDaoImplTest.deleteById(3);
        Optional<Group> expected = Optional.empty();

        assertThat(groupCrudDaoImplTest.findById(3), is(expected));
    }

    @Test
    void findByIdShouldBeReturnGroup() {
        Group expected = Group.builder()
                .withId(4)
                .withName("New name")
                .build();
        groupCrudDaoImplTest.save(expected);

        assertThat(groupCrudDaoImplTest.findById(4).get(), is(expected));
    }

    @Test
    void findAllEntityShouldBeReturnGroups() {
        List<Group> expected = Arrays.asList(
                Group.builder().withId(1).withName("One").build(),
                Group.builder().withId(2).withName("Two").build(),
                Group.builder().withId(3).withName("Three").build(),
                Group.builder().withId(4).withName("Four").build()
        );

        assertThat(groupCrudDaoImplTest.findAll(10), is(expected));
    }
}
