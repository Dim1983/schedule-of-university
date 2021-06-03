package com.loktionov.university.view;

import com.loktionov.university.entity.Group;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GroupViewProviderTest {
    @Mock
    private IntSupplier chooseUserNumber;

    @Mock
    private Supplier<String> chooseUserString;

    @InjectMocks
    private GroupViewProvider groupViewProvider;

    @Test
    void insertEntityShouldBeReturnEntity() {
        Group expected = Group.builder()
                .withId(1)
                .withName("test")
                .build();

        when(chooseUserString.get()).thenReturn("test");
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(groupViewProvider.insertEntity(), is(expected));
    }

    @Test
    void foundByIdShouldBeReturnIdNumber() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(groupViewProvider.foundById(), is(1));
    }

    @Test
    void chooseActionUserShouldBeReturnNumberOfChoose() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(groupViewProvider.chooseActionUser(), is(1));
    }

    @Test
    void deleteAuditoryShouldBeReturnChooseOfUser() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(groupViewProvider.deleteEntity(), is(1));
    }

    @Test
    void printResultFoundByIdPrintEntityFoundByIdOnScreen() {
        Group expected = Group.builder()
                .withId(1)
                .withName("test")
                .build();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        groupViewProvider.printResultFoundById(expected);

        assertThat(output.toString(), is("Your null is: Group(id=1, name=test, students=null, teachers=null)"
                + System.lineSeparator()));
    }

    @Test
    void printResultFindAllEntitiesOnScreen() {
        Group expected = Group.builder()
                .withId(1)
                .withName("test")
                .build();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        groupViewProvider.printResultFoundAll(Collections.singletonList(expected));

        assertThat(output.toString(), is("[Group(id=1, name=test, students=null, teachers=null)]"
                + System.lineSeparator()));
    }
}
