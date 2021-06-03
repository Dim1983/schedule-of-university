package com.loktionov.university.controller;

import com.loktionov.university.view.ViewProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UniversityController {
    private final ViewProvider viewProvider;
    private final AuditoryController auditoryController;
    private final CourseController courseController;
    private final DepartmentController departmentController;
    private final GroupController groupController;
    private final LessonController lessonController;
    private final StudentController studentController;
    private final TeacherController teacherController;

    public void mainChoose() {
        boolean flag = true;

        while (flag) {
            int choose = viewProvider.startChoose();
            switch (choose) {
                case 1:
                    auditoryController.actionWithAuditory();
                    break;
                case 2:
                    courseController.actionWithCourse();
                    break;
                case 3:
                    departmentController.actionWithDepartment();
                    break;
                case 4:
                    groupController.actionWithGroup();
                    break;
                case 5:
                    lessonController.actionWithLesson();
                    break;
                case 6:
                    studentController.actionWithStudent();
                    break;
                case 7:
                    teacherController.actionWithTeacher();
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + choose);
            }
        }
    }
}
