package com.loktionov.university.dao;

import com.loktionov.university.dao.impl.AuditoryCrudDaoImpl;
import com.loktionov.university.entity.Auditory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AuditoryCrudImplTest extends AbstractDaoTest {
    private AuditoryCrudDaoImpl auditoryCrudImplTest;

    @BeforeEach
    void init() {
        super.init();
        auditoryCrudImplTest = new AuditoryCrudDaoImpl(namedParameterJdbcTemplate);
    }

    @Test
    void saveShouldBeInsertDataOfTableAuditory() {
        Auditory auditory = new Auditory(5, 5);
        auditoryCrudImplTest.save(auditory);

        assertThat(auditoryCrudImplTest.findById(5).get(), is(auditory));
    }

    @Test
    void updateShouldBeUpdateDataOfTableAuditory() {
        Auditory auditory = new Auditory(4, 100);
        auditoryCrudImplTest.update(auditory);

        assertThat(auditoryCrudImplTest.findById(4).get(), is(auditory));
    }

    @Test
    void deleteByShouldBeDeletedDataOfTableAuditory() {
        auditoryCrudImplTest.deleteById(3);
        Optional<Auditory> expected = Optional.empty();

        assertThat(auditoryCrudImplTest.findById(3), is(expected));
    }

    @Test
    void findByIdShouldBeReturnAuditory() {
        Auditory expected = new Auditory(3, 3);
        auditoryCrudImplTest.save(expected);

        assertThat(auditoryCrudImplTest.findById(3).get(), equalTo(expected));
    }

    @Test
    void findAllEntityShouldBeReturnAuditories() {
        List<Auditory> expected = Arrays.asList(new Auditory(1, 1),
                new Auditory(2, 2),
                new Auditory(3, 3),
                new Auditory(4, 4));

        assertThat(auditoryCrudImplTest.findAll(0), is(expected));
    }
}
