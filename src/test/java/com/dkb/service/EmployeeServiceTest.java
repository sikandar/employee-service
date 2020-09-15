package com.dkb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.takeaway.employee.model.Employee;
import com.takeaway.employee.repository.EmployeeRepository;
import com.takeaway.employee.rest.request.EmployeeRequest;
import com.takeaway.employee.service.impl.EmployeeServiceImpl;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.testcontainers.shaded.com.google.common.io.Resources;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository accountRepository;

    @InjectMocks
    EmployeeServiceImpl service;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    @SneakyThrows
    @Ignore
    public void saveAccountT() {

        // given
        Employee employee = mapper.readValue(Resources.getResource("employee.json"), Employee.class);
        given(accountRepository.save(any())).willReturn(employee);

        EmployeeRequest request=new EmployeeRequest("abc@xyz.com", "Name1", LocalDate.now(), UUID.randomUUID());

        // when
       service.create(request);

        // then
        then(accountRepository).should().save(any());

    }


}
