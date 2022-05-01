package com.nishapro.repository;

import com.nishapro.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProcessRepository extends JpaRepository<Process, Long> {
    Optional<Process> findByPid(Long pid);

}