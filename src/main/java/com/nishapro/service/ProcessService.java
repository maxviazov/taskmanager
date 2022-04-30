package com.nishapro.service;

import com.nishapro.dto.ProcessDto;

import java.util.List;

public interface ProcessService {
    ProcessDto addProcess(ProcessDto dto);
    List<ProcessDto> listRunningProcesses(Long pid);

}
