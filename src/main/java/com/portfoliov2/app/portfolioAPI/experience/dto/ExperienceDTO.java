package com.portfoliov2.app.portfolioAPI.experience.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExperienceDTO {
    private boolean hidden;

    private Long id;

    private String image;

    private String company;

    private String position;

    private String description;

    private LocalDate startDate;

    private LocalDate finishDate;
}
