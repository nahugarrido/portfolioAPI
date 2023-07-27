package com.portfoliov2.app.portfolioAPI.education.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EducationDTO {

    private Long id;

    private String title;

    private String image;

    private String institution;

    private String description;

    private LocalDate startDate;

    private LocalDate finishDate;

    private boolean hidden;
}
