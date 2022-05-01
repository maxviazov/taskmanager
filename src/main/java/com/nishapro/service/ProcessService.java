package com.nishapro.service;

import com.nishapro.dto.ProcessDto;


public interface ProcessService {
    ProcessDto addAProcess(ProcessDto processDto);
    ProcessDto addProcessFIFO(ProcessDto processDto);
    ProcessDto findProcessByPid(Long pid);
//    Queue<ProcessDto> listRunningProcesses();
}
