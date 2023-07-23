package com.portfoliov2.app.portfolioAPI.person.entity;
import com.portfoliov2.app.portfolioAPI.education.entity.EducationEntity;
import com.portfoliov2.app.portfolioAPI.experience.entity.ExperienceEntity;
import com.portfoliov2.app.portfolioAPI.project.entity.ProjectEntity;
import com.portfoliov2.app.portfolioAPI.social.entity.SocialEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/// I'm using @Table and @Column as a good practice
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String lastName;

    private String seniority;

    private String description;

    /// profile image of the person
    private String profile;

    /// banner image of the person
    private String banner;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EducationEntity> educations;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectEntity> projects;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienceEntity> experiences;
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private SocialEntity social;

}
