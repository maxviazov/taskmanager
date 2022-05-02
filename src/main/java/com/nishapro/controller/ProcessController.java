package com.nishapro.controller;

import com.nishapro.dto.ProcessDto;
import com.nishapro.service.ProcessService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProcessController {
    private final ProcessService processService;

    @PostMapping("/process")
    public ProcessDto addProcess(@RequestBody ProcessDto processDto){
        return processService.addAProcess(processDto);
    }

    @PostMapping("/process/fifo")
    public ProcessDto addProcessFIFO(@RequestBody ProcessDto processDto){
        return processService.addProcessFIFO(processDto);
    }

    @GetMapping("/process/{pid}")
    public ProcessDto findProcessByPid(@PathVariable("pid") Long pid){
        return processService.findProcessByPid(pid);
    }
}
