package com.nishapro.converter;

import com.nishapro.dto.ProcessDto;
import com.nishapro.entity.Process;
import com.nishapro.entity.types.Priority;

import java.time.LocalDateTime;

public class ProcessConverter {

    private ProcessConverter(){}
    public static ProcessDto convertToDto(Process process){
        return ProcessDto.builder()
                .pid(process.getPid())
                .priority(process.getPriority())
                .creationTime(process.getCreationTime())
                .build();
    }
    public static Process convertToEntity(String priority){
        return Process.builder()
                .priority(Priority.valueOf(priority))
                .creationTime(LocalDateTime.now())
                .build();
    }

}
