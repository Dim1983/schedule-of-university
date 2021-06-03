package com.loktionov.university.controller;

import com.loktionov.university.view.ViewProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UniversityControllerTest {
    @Mock
    private ViewProvider viewProviderMock;

    @Mock
    private AuditoryController auditoryControllerMock;

    @Mock
    private CourseController courseControllerMock;

    @Mock
    private DepartmentController departmentControllerMock;

    @Mock
    private GroupController groupControllerMock;

    @Mock
    private LessonController lessonControllerMock;

    @Mock
    private StudentController studentControllerMock;

    @Mock
    private TeacherController teacherControllerMock;

    @InjectMocks
    private UniversityController universityController;

    @Test
    void mainChooseShouldByCallAnyControllers() {

        when(viewProviderMock.startChoose()).thenReturn(1, 2, 3, 4, 5, 6, 7, 8);

        universityController.mainChoose();

        verify(auditoryControllerMock, times(1)).actionWithAuditory();
        verify(courseControllerMock, times(1)).actionWithCourse();
        verify(departmentControllerMock, times(1)).actionWithDepartment();
        verify(groupControllerMock, times(1)).actionWithGroup();
        verify(lessonControllerMock, times(1)).actionWithLesson();
        verify(studentControllerMock, times(1)).actionWithStudent();
        verify(teacherControllerMock, times(1)).actionWithTeacher();
    }
}