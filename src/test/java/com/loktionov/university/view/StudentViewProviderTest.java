package com.loktionov.university.view;

import com.loktionov.university.entity.Phone;
import com.loktionov.university.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Collections;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentViewProviderTest {
    @Mock
    private IntSupplier chooseUserNumber;

    @Mock
    private Supplier<String> chooseUserString;

    @InjectMocks
    private StudentViewProvider studentViewProvider;

    @Test
    void insertEntityShouldBeReturnEntity() {
        Student expected = Student.builder()
                .withId(1)
                .withName("John")
                .withSecondName("Doo")
                .withEmail("1@test.ru")
                .withPassword("test")
                .withPhone(new Phone(1, "+7", "812", "000-00-00", "234"))
                .withBirthday(LocalDate.of(2021, 3, 2))
                .build();

        when(chooseUserNumber.getAsInt()).thenReturn(1).thenReturn(1).thenReturn(2021).thenReturn(3).thenReturn(2);
        when(chooseUserString.get()).thenReturn("John").thenReturn("Doo").thenReturn("1@test.ru")
                .thenReturn("test").thenReturn("+7").thenReturn("812").thenReturn("000-00-00").thenReturn("234");

        assertThat(studentViewProvider.insertEntity(), is(expected));
    }

    @Test
    void foundByIdShouldBeReturnIdNumber() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(studentViewProvider.foundById(), is(1));
    }

    @Test
    void chooseActionUserShouldBeReturnNumberOfChoose() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(studentViewProvider.chooseActionUser(), is(1));
    }

    @Test
    void deleteAuditoryShouldBeReturnChooseOfUser() {
        when(chooseUserNumber.getAsInt()).thenReturn(1);

        assertThat(studentViewProvider.deleteEntity(), is(1));
    }

    @Test
    void printResultFoundByIdPrintEntityFoundByIdOnScreen() {
        Student expected = Student.builder()
                .withId(1)
                .withName("John")
                .withSecondName("Doo")
                .withEmail("1@test.ru")
                .withPassword("test")
                .withPhone(new Phone(1, "+7", "812", "000-00-00", "234"))
                .withBirthday(LocalDate.of(2021, 3, 2))
                .build();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        studentViewProvider.printResultFoundById(expected);

        assertThat(output.toString(), is("Your null is: Student(super=AbstractUser(id=1, name=John, " +
                "secondName=Doo, birthday=2021-03-02, phone=Phone(id=1, codeOfCountry=+7, codeOfCity=812, " +
                "phoneNumber=000-00-00, additionalNumber=234), email=1@test.ru, password=test), status=null)"
                + System.lineSeparator()));
    }

    @Test
    void printResultFindAllEntitiesOnScreen() {
        Student expected = Student.builder()
                .withId(1)
                .withName("John")
                .withSecondName("Doo")
                .withEmail("1@test.ru")
                .withPassword("test")
                .withPhone(new Phone(1, "+7", "812", "000-00-00", "234"))
                .withBirthday(LocalDate.of(2021, 3, 2))
                .build();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        studentViewProvider.printResultFoundAll(Collections.singletonList(expected));

        assertThat(output.toString(), is("[Student(super=AbstractUser(id=1, name=John, secondName=Doo, " +
                "birthday=2021-03-02, phone=Phone(id=1, codeOfCountry=+7, codeOfCity=812, phoneNumber=000-00-00, " +
                "additionalNumber=234), email=1@test.ru, password=test), status=null)]" + System.lineSeparator()));
    }
}
