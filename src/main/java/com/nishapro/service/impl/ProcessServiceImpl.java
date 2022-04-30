package com.nishapro.service.impl;

import com.nishapro.converter.ProcessConverter;
import com.nishapro.dto.ProcessDto;
import com.nishapro.entity.Process;
import com.nishapro.entity.types.Priority;
import com.nishapro.repository.ProcessRepository;
import com.nishapro.service.ProcessService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ProcessServiceImpl implements ProcessService {
    private final ProcessRepository processRepository;

    @Override
    public ProcessDto addAProcess(ProcessDto processDto) {
        List<Priority> priorityList = new ArrayList<>(Arrays.asList(Priority.values()));
        int index = priorityList.indexOf(processDto.getPriority());
        String priority = String.valueOf(priorityList.get(index));
        Process process = processRepository.save(ProcessConverter.convertToEntity(priority));
        return ProcessConverter.convertToDto(process);
    }
}
