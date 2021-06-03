package com.loktionov.university.controller;

import com.loktionov.university.dao.AuditoryDao;
import com.loktionov.university.entity.Auditory;
import com.loktionov.university.view.AuditoryViewProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuditoryControllerTest {
    @Mock
    private AuditoryViewProvider auditoryViewProviderMock;

    @Mock
    private AuditoryDao auditoryCrudDaoMock;

    @InjectMocks
    private AuditoryController auditoryController;

    @Test
    void actionWithAuditoryShouldBeCallDaoAndViewMethods() {
        List<Auditory> auditories = Arrays.asList(new Auditory(1,1), new Auditory(2,2));
        Auditory auditory = new Auditory(1, 1);
        when(auditoryViewProviderMock.chooseActionUser()).thenReturn(1, 2, 3, 4, 5, 6);
        when(auditoryViewProviderMock.setEntity()).thenReturn(auditory);
        when(auditoryViewProviderMock.foundById()).thenReturn(1);
        when(auditoryCrudDaoMock.findAll(anyInt())).thenReturn(auditories);

        auditoryController.actionWithAuditory();

        verify(auditoryCrudDaoMock).save(any());
        verify(auditoryCrudDaoMock).findById(1);
        verify(auditoryViewProviderMock).printResultFoundById(any());
        verify(auditoryViewProviderMock,times(10)).printResultFoundAll(auditories);
        verify(auditoryCrudDaoMock).update(any());
        verify(auditoryCrudDaoMock).deleteById(anyInt());
    }
}
