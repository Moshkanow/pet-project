package ru.rizvan.free_badoo.repository;

import ru.rizvan.free_badoo.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository
        extends JpaRepository<Account, Long> {
    Account findByLogin(String login);
}
