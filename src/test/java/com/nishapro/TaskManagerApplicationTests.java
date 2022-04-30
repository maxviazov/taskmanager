package com.nishapro;

import com.nishapro.controller.ProcessController;
import com.nishapro.entity.Process;
import com.nishapro.entity.types.Priority;
import com.nishapro.repository.ProcessRepository;
import com.nishapro.service.ProcessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskManagerApplicationTests {
    @Autowired
    private ProcessRepository processRepository;
    private ProcessService processService;
    private ProcessController processController;
    private Process process;
    @Test
    void contextLoads() {
        Process res = Process.builder()
                .priority(Priority.LOW)
                .build();
        System.out.println(res);
    }

}
