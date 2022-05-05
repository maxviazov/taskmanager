package com.nishapro.controller;

import com.nishapro.dto.ProcessDto;
import com.nishapro.service.ProcessService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProcessController {
    private final ProcessService processService;

    @GetMapping("/process")
    public List<ProcessDto> getAllProcess(){
        return processService.getAllProcesses();
    }
    @PostMapping("/process")
    public ProcessDto addProcess(@RequestBody ProcessDto processDto){
        return processService.addAProcess(processDto);
    }

    @GetMapping("/process/time")
    public List<ProcessDto> findAllProcessesByCreationTime(){
        return processService.sortProcessesByCreationTime();
    }

    @GetMapping("/process/priority")
    public List<ProcessDto> sortProcessesByPriority(){
        return processService.sortProcessesByPriority();
    }

    @GetMapping("/process/pid")
    public List<ProcessDto> sortProcessesByPid(){
        return processService.sortProcessesByPid();
    }

    @DeleteMapping("/process/{pid}")
    public void deleteProcessByPid(@PathVariable("pid") Long pid){
        processService.deleteProcessByPid(pid);
    }
    @DeleteMapping("/process")
    public void deleteAllProcesses(){
        processService.deleteAllProcesses();
    }
    @DeleteMapping("/process/priority/{priority}")
    public void deleteGroupProcessByPriority(@PathVariable("priority") String priority){
        processService.deleteGroupProcessByPriority(priority.toUpperCase());
    }

}
