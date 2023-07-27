package com.portfoliov2.app.portfolioAPI.work.dto;

import lombok.Data;

@Data
public class WorkSaveDTO {
    private boolean hidden;

    private String image;

    private String repositoryLink;

    private String liveSourceLink;

    private String title;

    private String description;

    private String category;
}
