package com.nishapro.converter;

import com.nishapro.dto.ProcessDto;
import com.nishapro.entity.Process;
import com.nishapro.entity.type.PriorityConverter;
import lombok.AllArgsConstructor;

import javax.print.event.PrintEvent;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Converter {
    public static ProcessDto convertToDto(Process process){
        return ProcessDto.builder()
                .pid(process.getPid())
                .priority(process.str getPriority())
                .build();
    }
    public static Process convertToEntity(ProcessDto dto, List<Process> priorities){
        return Process.builder()
                .priority(priorities.stream().map(Process::getPriority).collect(Collectors.toList()));
                .build();
    }
}
