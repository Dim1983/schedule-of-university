package com.loktionov.university.controller;

import com.loktionov.university.dao.GroupDao;
import com.loktionov.university.entity.Group;
import com.loktionov.university.view.GroupViewProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
public class GroupController {
    private static final Integer LIMIT_QUANTITY_OF_PAGES = 10;
    private static final Integer STEP_OF_PAGES = 10;

    private final GroupViewProvider groupViewProvider;
    private final GroupDao groupDao;

    public void actionWithGroup() {
        boolean flag = true;

        while (flag) {
            Integer choose = groupViewProvider.chooseActionUser();

            switch (choose) {
                case 1:
                    groupDao.save(groupViewProvider.setEntity());
                    break;
                case 2:
                    Group group = groupDao.findById(groupViewProvider.foundById()).isPresent()
                            ? groupDao.findById(groupViewProvider.foundById()).get()
                            : Group.builder()
                            .withId(null)
                            .withName(null)
                            .build();
                    groupViewProvider.printResultFoundById(group);
                    break;
                case 3:
                    AtomicInteger count = new AtomicInteger();
                    Stream.iterate(0, i -> i + 1).limit(LIMIT_QUANTITY_OF_PAGES)
                            .map(s -> groupDao.findAll(count.getAndIncrement() * STEP_OF_PAGES))
                            .filter(s -> !s.isEmpty())
                            .forEach(groupViewProvider::printResultFoundAll);
                    break;
                case 4:
                    groupDao.update(groupViewProvider.updateEntity());
                    break;
                case 5:
                    groupDao.deleteById(groupViewProvider.deleteEntity());
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
