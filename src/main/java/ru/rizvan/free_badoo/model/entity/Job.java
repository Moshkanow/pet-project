package ru.rizvan.free_badoo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "description")
    private String description;

    @Column(name = "job_status")
    private String jobStatus;

    @Column(name = "sum_of_transaction")
    private int sumOfTransaction;

    @Column(name = "transaction_status")
    private String transactionStatus;

    @Column(name = "rate")
    private int rate;

    @Column(name = "executor")
    private String executor;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
