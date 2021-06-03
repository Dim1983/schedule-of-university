package com.loktionov.university.controller;

import com.loktionov.university.dao.AuditoryDao;
import com.loktionov.university.entity.Auditory;
import com.loktionov.university.view.AuditoryViewProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
public class AuditoryController {
    private static final Integer LIMIT_QUANTITY_OF_PAGES = 10;
    private static final Integer STEP_OF_PAGES = 10;

    private final AuditoryViewProvider auditoryViewProvider;
    private final AuditoryDao auditoryCrudDao;

    public void actionWithAuditory() {
        boolean flag = true;

        while (flag) {
            Integer choose = auditoryViewProvider.chooseActionUser();

            switch (choose) {
                case 1:
                    auditoryCrudDao.save(auditoryViewProvider.setEntity());
                    break;
                case 2:
                    Auditory auditory = auditoryCrudDao.findById(auditoryViewProvider.foundById()).isPresent()
                            ? auditoryCrudDao.findById(auditoryViewProvider.foundById()).get()
                            : new Auditory(null, null);
                    auditoryViewProvider.printResultFoundById(auditory);
                    break;
                case 3:
                    AtomicInteger count = new AtomicInteger();
                    Stream.iterate(0, i -> i + 1).limit(LIMIT_QUANTITY_OF_PAGES)
                            .map(s -> auditoryCrudDao.findAll(count.getAndIncrement() * STEP_OF_PAGES))
                            .filter(s -> !s.isEmpty())
                            .forEach(auditoryViewProvider::printResultFoundAll);
                    break;
                case 4:
                    auditoryCrudDao.update(auditoryViewProvider.updateEntity());
                    break;
                case 5:
                    auditoryCrudDao.deleteById(auditoryViewProvider.deleteEntity());
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
