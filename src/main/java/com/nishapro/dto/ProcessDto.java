package com.nishapro.dto;

import com.nishapro.entity.types.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ProcessDto {
    private Long pid;
    private Priority priority;
}
