package com.nishapro.entity;

import com.nishapro.entity.type.Priority;
import com.nishapro.entity.type.PriorityConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "process")
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid", nullable = false)
    private Long pid;

    @Convert(converter = PriorityConverter.class)
    private Priority priority;

}