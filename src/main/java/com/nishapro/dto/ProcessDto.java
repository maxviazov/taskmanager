package com.nishapro.dto;

import com.nishapro.entity.types.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Builder
public class ProcessDto {
    private Long pid;
    private Priority priority;
    private LocalDateTime creationTime;
}
