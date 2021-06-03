package com.loktionov.university.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewProviderTest {
    ViewProvider viewProviderTest = new ViewProvider();

    @Test
    void startChooseShouldBeShowTableWithVariantsActions() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ByteArrayInputStream input = new ByteArrayInputStream("1".getBytes());
        System.setIn(input);

        viewProviderTest.startChoose();

        assertEquals("Which data interesting for you:\n" +
                "1. Data of Auditory;\n" +
                "2. Data of Courses;\n" +
                "3. Data of Department;\n" +
                "4. Data of Group;\n" +
                "5. Data of Lesson;\n" +
                "6. Data of Student;\n" +
                "7. Data of Teacher;\n" +
                "8. Exit" + System.lineSeparator(), output.toString());
    }

    @Test
    void actionWithTableShouldBeReturnChooseOfUser() {
        ByteArrayInputStream input = new ByteArrayInputStream("1".getBytes());
        System.setIn(input);

        assertThat(viewProviderTest.startChoose(), is(1));
    }
}
