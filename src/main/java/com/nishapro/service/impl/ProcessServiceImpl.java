package com.nishapro.service.impl;

import com.nishapro.converter.ProcessConverter;
import com.nishapro.dto.ProcessDto;
import com.nishapro.entity.Process;
import com.nishapro.entity.types.Priority;
import com.nishapro.repository.ProcessRepository;
import com.nishapro.service.ProcessService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@AllArgsConstructor
public class ProcessServiceImpl implements ProcessService {
    private final ProcessRepository processRepository;

    @Override
    public List<ProcessDto> getAllProcesses() {
        return processRepository.findAll().stream()
                .map(ProcessConverter::convertToDto)
                .toList();
    }

    @Override
    public ProcessDto addAProcess(ProcessDto processDto) {
        if (checkCapacity()){
            System.out.println(checkCapacity());
            LinkedList<ProcessDto> processesList = new LinkedList<>(processRepository.findAll().stream()
                    .map(ProcessConverter::convertToDto)
                    .toList());
            System.out.println(processesList);
            try {
                if (processesList.peekLast() != null && processesList.peekLast().getPriority().equals(Priority.LOW)) {
                    processesList.pollLast();
                }
            }catch (Exception e){
                System.out.println("The process cannot be added");
            }

        }
        List<Priority> priorityList = new ArrayList<>(Arrays.asList(Priority.values()));
        int index = priorityList.indexOf(processDto.getPriority());
        String priority = String.valueOf(priorityList.get(index));
        Process process = processRepository.save(ProcessConverter.convertToEntity(priority));
        return ProcessConverter.convertToDto(process);
    }

    @Override
    public List<ProcessDto> sortProcessesByCreationTime() {
        List<ProcessDto> processDtos = new ArrayList<>(processRepository.findAll().stream()
                .map(ProcessConverter::convertToDto)
                .toList());
        return processDtos.stream().sorted(Comparator.comparing(ProcessDto::getCreationTime).reversed()).toList();
    }

    @Override
    public List<ProcessDto> sortProcessesByPriority() {
        List<ProcessDto> processDtos = new ArrayList<>(processRepository.findAll().stream()
                .map(ProcessConverter::convertToDto)
                .toList());
        return processDtos.stream().sorted(Comparator.comparing(ProcessDto::getPriority)).toList();
    }

    @Override
    public List<ProcessDto> sortProcessesByPid() {
        List<ProcessDto> processDtos = new ArrayList<>(processRepository.findAll().stream()
                .map(ProcessConverter::convertToDto)
                .toList());
        return processDtos.stream().sorted(Comparator.comparing(ProcessDto::getPid)).toList();
    }

    @Override
    @Transactional
    public void deleteProcessByPid(Long pid) {
        processRepository.deleteProcessByPid(pid);
    }

    @Override
    @Transactional
    public void deleteGroupProcessByPriority(String priority) {
        processRepository.deleteAllByPriority(Priority.valueOf(priority));
    }

    @Override
    public void deleteAllProcesses() {
        processRepository.deleteAll();
    }


    private boolean checkCapacity() {
        List<Process> processes = new ArrayList<>(9);
        processes.addAll(processRepository.findAll());
        return processes.size() >= 10;
    }
}
