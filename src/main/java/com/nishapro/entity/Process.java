package com.nishapro.entity;

import com.nishapro.entity.types.Priority;
import com.nishapro.entity.types.PriorityConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "PROCESS")
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PID", nullable = false)
    private Long pid;

    @Column(name = "PRIORITY")
    @Convert(converter = PriorityConverter.class)
    private Priority priority;

    @Column(name = "CREATION_TIME")
    private LocalDateTime creationTime;

}