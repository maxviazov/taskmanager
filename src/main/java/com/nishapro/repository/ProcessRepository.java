package com.nishapro.repository;

import com.nishapro.dto.ProcessDto;
import com.nishapro.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessRepository extends JpaRepository<Process, Long> {
    List<ProcessDto> findProcessByPid(Long pid);
}