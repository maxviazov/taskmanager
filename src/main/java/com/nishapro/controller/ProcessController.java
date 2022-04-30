package com.nishapro.controller;

import com.nishapro.dto.ProcessDto;
import com.nishapro.service.ProcessService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProcessController {
    private final ProcessService processService;

    @PostMapping("/process")
    public ProcessDto addProcess(ProcessDto processDto){
        return processService.addProcess(processDto);
    }
}
