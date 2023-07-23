package com.portfoliov2.app.portfolioAPI.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/// I'm using @Table and @Column as a good practice
@Entity
@Getter
@Setter
@Table(name = "project")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String img;

    private String repositoryLink;

    private String liveSourceLink;

    private String title;

    private boolean hidden;

    private int priority;

    private String description;

    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "person_id")
    private PersonEntity person;

}
