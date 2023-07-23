package com.portfoliov2.app.portfolioAPI.person.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PersonSaveDTO {
    private String name;

    private String lastName;

    private String seniority;

    private String description;

    /// profile image of the person
    private String profile;

    /// banner image of the person
    private String banner;
}
