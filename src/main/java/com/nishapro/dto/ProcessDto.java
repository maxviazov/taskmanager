package com.nishapro.dto;

import com.nishapro.entity.type.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ProcessDto {
    private final Long pid;
    private final List<Priority> priority;
}
