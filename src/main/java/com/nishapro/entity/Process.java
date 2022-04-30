package com.nishapro.entity;

import com.nishapro.entity.types.Priority;
import com.nishapro.entity.types.PriorityConverter;
import lombok.*;

import javax.persistence.*;

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

    @Column(name = "priority")
    @Convert(converter = PriorityConverter.class)
    private Priority priority;

}