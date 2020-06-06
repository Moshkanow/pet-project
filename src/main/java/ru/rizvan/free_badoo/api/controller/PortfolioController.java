package ru.rizvan.free_badoo.api.controller;

import ru.rizvan.free_badoo.model.dto.PortfolioDto;
import ru.rizvan.free_badoo.service.PortfolioService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @RequestMapping("/add")
    public void add(@RequestBody PortfolioDto portfolioDto) {
        portfolioService.add(portfolioDto.getLogin(), portfolioDto.getInfo());
    }
}
