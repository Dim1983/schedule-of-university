package com.loktionov.university.view;

import com.loktionov.university.entity.Course;
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
class CourseViewProviderTest {
    @Mock
    private IntSupplier chooseUserNumber;

    @Mock
    private Supplier<String> chooseUserString;

    @InjectMocks
    private CourseViewProvider courseViewProvider;

    @Test
    void insertEntityShouldBeReturnEntity() {
        Course expected = Course.builder()
                .withId(1)
                .withName("test")
                .build();

        when(chooseUserString.get()).thenReturn("test");
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(courseViewProvider.insertEntity(), is(expected));
    }

    @Test
    void foundByIdShouldBeReturnIdNumber() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(courseViewProvider.foundById(), is(1));
    }

    @Test
    void chooseActionUserShouldBeReturnNumberOfChoose() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(courseViewProvider.chooseActionUser(), is(1));
    }

    @Test
    void deleteAuditoryShouldBeReturnChooseOfUser() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(courseViewProvider.deleteEntity(), is(1));
    }

    @Test
    void printResultFoundByIdPrintEntityFoundByIdOnScreen() {
        Course expected = Course.builder()
                .withId(1)
                .withName("test")
                .build();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        courseViewProvider.printResultFoundById(expected);

        assertThat(output.toString(), is("Your null is: Course(id=1, name=test, lessons=null, groups=null)"
                + System.lineSeparator()));
    }

    @Test
    void printResultFindAllEntitiesOnScreen() {
        Course expected = Course.builder()
                .withId(1)
                .withName("test")
                .build();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        courseViewProvider.printResultFoundAll(Collections.singletonList(expected));

        assertThat(output.toString(), is("[Course(id=1, name=test, lessons=null, groups=null)]"
                + System.lineSeparator()));
    }
}
