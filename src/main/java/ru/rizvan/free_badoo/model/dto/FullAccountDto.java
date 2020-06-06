package ru.rizvan.free_badoo.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class FullAccountDto {
    private String login;
    private String name;
    private Integer ratingSum;
    private Integer ratingNumber;
    private List<PortfolioDto> portfolioList;
}
