package ru.rizvan.free_badoo.service;

import ru.rizvan.free_badoo.model.dto.JobCreatorDto;
import ru.rizvan.free_badoo.model.entity.Job;
import ru.rizvan.free_badoo.model.enums.JobStatus;
import ru.rizvan.free_badoo.model.enums.TransactionStatus;
import ru.rizvan.free_badoo.repository.AccountRepository;
import ru.rizvan.free_badoo.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    private final AccountRepository accountRepository;
    private final JobRepository jobRepository;

    public JobService(AccountRepository accountRepository, JobRepository jobRepository) {
        this.accountRepository = accountRepository;
        this.jobRepository = jobRepository;
    }

    public void createJob(String login, String description, int price) {
        Job job = Job.builder()
                .description(description)
                .jobStatus(JobStatus.LOOKING_FOR.name())
                .sumOfTransaction(price)
                .transactionStatus(TransactionStatus.FREEZE.name())
                .account(accountRepository.findByLogin(login))
                .build();
        jobRepository.save(job);
    }

    public List<JobCreatorDto> findAll() {
        List<JobCreatorDto> jobCreatorDtos = new ArrayList<>();
        List<Job> jobs = jobRepository.findAll();

        for (Job job : jobs) {
            jobCreatorDtos.add(JobCreatorDto
                    .builder()
                    .login(job.getAccount().getLogin())
                    .description(job.getDescription())
                    .price(job.getSumOfTransaction())
                    .jobId(job.getJobId())
                    .build());
        }
        return jobCreatorDtos;
    }
}
