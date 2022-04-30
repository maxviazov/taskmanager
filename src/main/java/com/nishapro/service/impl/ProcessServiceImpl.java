package com.nishapro.service.impl;

import com.nishapro.converter.Converter;
import com.nishapro.dto.ProcessDto;
import com.nishapro.entity.Process;
import com.nishapro.repository.ProcessRepository;
import com.nishapro.service.ProcessService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProcessServiceImpl implements ProcessService {
    private final ProcessRepository processRepository;
    @Override
    public ProcessDto addProcess(ProcessDto dto) {
        Process process = processRepository.save(Converter.convertToEntity(dto, ));
        return Converter.convertToDto(process);
    }

    @Override
    public List<ProcessDto> listRunningProcesses(Long pid) {
        return processRepository.findProcessByPid(pid);
    }

}
