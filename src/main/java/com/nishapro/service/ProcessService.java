package com.nishapro.service;

import com.nishapro.dto.ProcessDto;

import java.util.List;


public interface ProcessService {
    List<ProcessDto> getAllProcesses();
    ProcessDto addAProcess(ProcessDto processDto);
    List<ProcessDto> sortProcessesByCreationTime();
    List<ProcessDto> sortProcessesByPriority();
    List<ProcessDto> sortProcessesByPid();
    void deleteProcessByPid(Long pid);
    void deleteGroupProcessByPriority(String priority);
    void deleteAllProcesses();
}
