package com.loktionov.university.view;

import com.loktionov.university.entity.Auditory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.function.IntSupplier;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuditoryViewProviderTest {
    @Mock
    private IntSupplier chooseUserNumber;

    @InjectMocks
    private AuditoryViewProvider auditoryViewProvider;

    @Test
    void insertEntityShouldBeReturnEntity() {
        Auditory expected = new Auditory(1, 2);

        when(chooseUserNumber.getAsInt()).thenReturn(1).thenReturn(2);

        assertThat(auditoryViewProvider.insertEntity(), is(expected));
    }

    @Test
    void foundByIdShouldBeReturnIdNumber() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(auditoryViewProvider.foundById(), is(1));
    }

    @Test
    void chooseActionUserShouldBeReturnNumberOfChoose() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(auditoryViewProvider.chooseActionUser(), is(1));
    }

    @Test
    void deleteAuditoryShouldBeReturnChooseOfUser() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(auditoryViewProvider.deleteEntity(), is(1));
    }

    @Test
    void printResultFoundByIdPrintEntityFoundByIdOnScreen() {
        Auditory auditory = new Auditory(1, 2);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        auditoryViewProvider.printResultFoundById(auditory);

        assertThat(output.toString(), is("Your null is: Auditory(id=1, number=2)"
                + System.lineSeparator()));
    }

    @Test
    void printResultFindAllEntitiesOnScreen() {
        Auditory expected = new Auditory(1, 2);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        auditoryViewProvider.printResultFoundAll(Collections.singletonList(expected));

        assertThat(output.toString(), is("[Auditory(id=1, number=2)]" + System.lineSeparator()));
    }

    @Test
    void setEntityShouldBeReturnEntity() {
        Auditory expected = new Auditory(1, 2);

        when(chooseUserNumber.getAsInt()).thenReturn(1).thenReturn(2);

        assertThat(auditoryViewProvider.setEntity(), is(expected));
    }

    @Test
    void updateEntityShouldBeReturnEntity() {
        Auditory expected = new Auditory(1, 2);

        when(chooseUserNumber.getAsInt()).thenReturn(1).thenReturn(2);

        assertThat(auditoryViewProvider.updateEntity(), is(expected));
    }
}
