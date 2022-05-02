package com.nishapro.service.impl;

import com.nishapro.converter.ProcessConverter;
import com.nishapro.dto.ProcessDto;
import com.nishapro.entity.Process;
import com.nishapro.entity.types.Priority;
import com.nishapro.repository.ProcessRepository;
import com.nishapro.service.ProcessService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@AllArgsConstructor
public class ProcessServiceImpl implements ProcessService {
    private final ProcessRepository processRepository;

    @Override
    public ProcessDto addAProcess(ProcessDto processDto) {
        if (checkCapacity()){
            throw new RuntimeException("Reach the maximum stack size");
        }
        List<Priority> priorityList = new ArrayList<>(Arrays.asList(Priority.values()));
        int index = priorityList.indexOf(processDto.getPriority());
        String priority = String.valueOf(priorityList.get(index));
        Process process = processRepository.save(ProcessConverter.convertToEntity(priority));
        return ProcessConverter.convertToDto(process);
    }

    @Override
    public ProcessDto addProcessFIFO(ProcessDto processDto) {
        Deque<Process> processes = new ArrayDeque<>(processRepository.findAll());
        if(!checkCapacity()){
            processes.pollLast();
            processes.addFirst(processRepository.save(ProcessConverter.convertToEntity(String.valueOf(processDto))));
        }
        return ProcessConverter.convertToDto(processes.getFirst());
    }

    private boolean checkCapacity() {
        List<Process> processes = new ArrayList<>(9);
        processes.addAll(processRepository.findAll());
        return processes.size() >= 10;
    }

    @Override
    public ProcessDto findProcessByPid(Long pid) {
        Process process = processRepository.findByPid(pid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        System.out.println(process);
        return ProcessConverter.convertToDto(process);
    }



}
