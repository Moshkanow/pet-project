package ru.rizvan.free_badoo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "account_type")
    private String account_type;

    @Column(name = "balance")
    private int balance;

    @Column(name = "sum_of_ratings")
    private int sumOfRatings;

    @Column(name = "number_of_ratings")
    private int numberOfRatings;

    @OneToMany(mappedBy = "account")
    private Set<Portfolio> portfolios;

    @OneToMany(mappedBy = "account")
    private Set<Job> jobs;
}
