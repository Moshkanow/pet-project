package ru.rizvan.free_badoo.repository;

import ru.rizvan.free_badoo.model.entity.Account;
import ru.rizvan.free_badoo.model.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository
        extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByAccount(Account account);
}
