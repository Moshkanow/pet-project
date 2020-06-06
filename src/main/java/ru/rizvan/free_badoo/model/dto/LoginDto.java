package ru.rizvan.free_badoo.model.dto;

import ru.rizvan.free_badoo.model.enums.AccountType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginDto {
    private String login;
    private String password;
    private AccountType accountType;
    private String fullname;
}
