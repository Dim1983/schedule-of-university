package com.loktionov.university.config;

import com.loktionov.university.view.AuditoryViewProvider;
import com.loktionov.university.view.CourseViewProvider;
import com.loktionov.university.view.DepartmentViewProvider;
import com.loktionov.university.view.GroupViewProvider;
import com.loktionov.university.view.LessonViewProvider;
import com.loktionov.university.view.StudentViewProvider;
import com.loktionov.university.view.TeacherViewProvider;
import com.loktionov.university.view.ViewProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

@Configuration
public class ViewProviderConfig {
    @Bean
    @Qualifier("chooseUserNumber")
    public IntSupplier getChooseUserNumber() {
        return ()->new Scanner(System.in).nextInt();
    }

    @Bean
    @Qualifier("chooseUserString")
    public Supplier<String> getChooseUserString() {
        return ()->new Scanner(System.in).next();
    }

    @Bean
    public AuditoryViewProvider auditoryViewProvider(@Value("Auditory") String tableName,
                                                     @Qualifier("chooseUserNumber") IntSupplier chooseUserNumber,
                                                     @Qualifier("chooseUserString")Supplier<String> chooseUserString) {
        return new AuditoryViewProvider(tableName,chooseUserNumber, chooseUserString);
    }

    @Bean
    public CourseViewProvider courseViewProvider(@Value("Course") String tableName,
                                                 @Qualifier("chooseUserNumber") IntSupplier chooseUserNumber,
                                                 @Qualifier("chooseUserString")Supplier<String> chooseUserString) {
        return new CourseViewProvider(tableName, chooseUserNumber, chooseUserString);
    }

    @Bean
    public DepartmentViewProvider departmentViewProvider(@Value("Department") String tableName,
                                                         @Qualifier("chooseUserNumber") IntSupplier chooseUserNumber,
                                                         @Qualifier("chooseUserString")Supplier<String> chooseUserString) {
        return new DepartmentViewProvider(tableName, chooseUserNumber, chooseUserString);
    }

    @Bean
    public GroupViewProvider groupViewProvider(@Value("Group") String tableName,
                                               @Qualifier("chooseUserNumber") IntSupplier chooseUserNumber,
                                               @Qualifier("chooseUserString")Supplier<String> chooseUserString) {
        return new GroupViewProvider(tableName, chooseUserNumber, chooseUserString);
    }

    @Bean
    public LessonViewProvider lessonViewProvider(@Value("Lesson") String tableName,
                                                 @Qualifier("chooseUserNumber") IntSupplier chooseUserNumber,
                                                 @Qualifier("chooseUserString")Supplier<String> chooseUserString) {
        return new LessonViewProvider(tableName, chooseUserNumber, chooseUserString);
    }

    @Bean
    public StudentViewProvider studentViewProvider(@Value("Student") String tableName,
                                                   @Qualifier("chooseUserNumber") IntSupplier chooseUserNumber,
                                                   @Qualifier("chooseUserString")Supplier<String> chooseUserString) {
        return new StudentViewProvider(tableName, chooseUserNumber, chooseUserString);
    }

    @Bean
    public TeacherViewProvider teacherViewProvider(@Value("Student") String tableName,
                                                   @Qualifier("chooseUserNumber") IntSupplier chooseUserNumber,
                                                   @Qualifier("chooseUserString")Supplier<String> chooseUserString) {
        return new TeacherViewProvider(tableName, chooseUserNumber, chooseUserString);
    }

    @Bean
    public ViewProvider viewProvider() {
        return new ViewProvider();
    }
}
