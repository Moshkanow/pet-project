package ru.rizvan.free_badoo.api.controller;

import ru.rizvan.free_badoo.model.dto.FullAccountDto;
import ru.rizvan.free_badoo.model.dto.LoginDto;
import ru.rizvan.free_badoo.service.AccountService;
import ru.rizvan.free_badoo.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

    private final AccountService accountService;
    private final PortfolioService portfolioService;

    public AccountController(AccountService accountService, PortfolioService portfolioService) {
        this.accountService = accountService;
        this.portfolioService = portfolioService;
    }

    @RequestMapping("/registration")
    public void registration(@RequestBody LoginDto login, HttpServletResponse response) {
        if (accountService.registration(login.getLogin(), login.getPassword(), login.getFullname(), login.getAccountType())) {
            response.setStatus(200);
            return;
        }
        response.setStatus(300);
    }

    @RequestMapping("/money")
    public String moneyCheck(@RequestBody LoginDto login) {
        return "{\"money\":\"" + accountService.checkMoney(login.getLogin()) + "\"}";
    }

    @GetMapping("/account")
    public FullAccountDto account(@RequestParam(value = "login") String login) {
        return accountService.getAccount(login, portfolioService.findByLogin(login));
    }
}
