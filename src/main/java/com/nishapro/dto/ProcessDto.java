package com.nishapro.dto;

import com.nishapro.entity.type.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class ProcessDto {
    private final Long id;
    @NotNull(message = "No process priority")
    private final Priority priority;
}
