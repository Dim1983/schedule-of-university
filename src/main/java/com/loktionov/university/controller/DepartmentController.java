package com.loktionov.university.controller;

import com.loktionov.university.dao.DepartmentDao;
import com.loktionov.university.entity.Department;
import com.loktionov.university.view.DepartmentViewProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
public class DepartmentController {
    private static final Integer LIMIT_QUANTITY_OF_PAGES = 10;
    private static final Integer STEP_OF_PAGES = 10;

    private final DepartmentViewProvider departmentViewProvider;
    private final DepartmentDao departmentDao;

    public void actionWithDepartment() {
        boolean flag = true;

        while (flag) {
            Integer choose = departmentViewProvider.chooseActionUser();

            switch (choose) {
                case 1:
                    departmentDao.save(departmentViewProvider.setEntity());
                    break;
                case 2:
                    Department department = departmentDao.findById(departmentViewProvider.foundById()).isPresent()
                            ? departmentDao.findById(departmentViewProvider.foundById()).get()
                            : Department.builder()
                            .withId(null)
                            .withName(null)
                            .build();
                    departmentViewProvider.printResultFoundById(department);
                    break;
                case 3:
                    AtomicInteger count = new AtomicInteger();
                    Stream.iterate(0, i -> i + 1).limit(LIMIT_QUANTITY_OF_PAGES)
                            .map(s -> departmentDao.findAll(count.getAndIncrement() * STEP_OF_PAGES))
                            .filter(s -> !s.isEmpty())
                            .forEach(departmentViewProvider::printResultFoundAll);
                    break;
                case 4:
                    departmentDao.update(departmentViewProvider.updateEntity());
                    break;
                case 5:
                    departmentDao.deleteById(departmentViewProvider.deleteEntity());
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}
