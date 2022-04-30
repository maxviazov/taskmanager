package com.nishapro.converter;

import com.nishapro.dto.ProcessDto;
import com.nishapro.entity.Process;
import com.nishapro.entity.types.Priority;

public class ProcessConverter {

    private ProcessConverter(){}
    public static ProcessDto convertToDto(Process process){
        return ProcessDto.builder()
                .pid(process.getPid())
                .priority(process.getPriority())
                .build();
    }
    public static Process convertToEntity(String priority){
        return Process.builder()
                .priority(Priority.valueOf(priority))
                .build();
    }
}
