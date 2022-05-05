package com.nishapro.repository;

import com.nishapro.entity.Process;
import com.nishapro.entity.types.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessRepository extends JpaRepository<Process, Long> {
    void deleteProcessByPid(Long pid);
    void deleteAllByPriority(Priority priority);
}