package ru.rizvan.free_badoo.repository;

import ru.rizvan.free_badoo.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository
        extends JpaRepository<Job, Long> {
}
