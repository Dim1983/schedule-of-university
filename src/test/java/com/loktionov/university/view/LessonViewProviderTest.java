package com.loktionov.university.view;

import com.loktionov.university.entity.Lesson;
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
class LessonViewProviderTest {
    @Mock
    private IntSupplier chooseUserNumber;

    @Mock
    private Supplier<String> chooseUserString;

    @InjectMocks
    private LessonViewProvider lessonViewProvider;

    @Test
    void insertEntityShouldBeReturnEntity() {
        Lesson expected = new Lesson(1, "test");

        when(chooseUserString.get()).thenReturn("test");
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(lessonViewProvider.insertEntity(), is(expected));
    }

    @Test
    void foundByIdShouldBeReturnIdNumber() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(lessonViewProvider.foundById(), is(1));
    }

    @Test
    void chooseActionUserShouldBeReturnNumberOfChoose() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(lessonViewProvider.chooseActionUser(), is(1));
    }

    @Test
    void deleteAuditoryShouldBeReturnChooseOfUser() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(lessonViewProvider.deleteEntity(), is(1));
    }

    @Test
    void printResultFoundByIdPrintEntityFoundByIdOnScreen() {
        Lesson expected = new Lesson(1, "test");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        lessonViewProvider.printResultFoundById(expected);

        assertThat(output.toString(), is("Your null is: Lesson(id=1, name=test)"
                + System.lineSeparator()));
    }

    @Test
    void printResultFindAllEntitiesOnScreen() {
        Lesson expected = new Lesson(1, "test");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        lessonViewProvider.printResultFoundAll(Collections.singletonList(expected));

        assertThat(output.toString(), is("[Lesson(id=1, name=test)]" + System.lineSeparator()));
    }
}
