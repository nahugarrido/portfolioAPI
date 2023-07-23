package com.portfoliov2.app.portfolioAPI.person.entity;
import com.portfoliov2.app.portfolioAPI.education.entity.EducationEntity;
import com.portfoliov2.app.portfolioAPI.experience.entity.ExperienceEntity;
import com.portfoliov2.app.portfolioAPI.project.entity.ProjectEntity;
import com.portfoliov2.app.portfolioAPI.social.entity.SocialEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/// I'm using @Table and @Column as a good practice
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Person")
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

    /// save the ids of the svg images that should be displayed in the portfolio
    @Column(name = "skills")
    private ArrayList<Integer> skills;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EducationEntity> educations = new ArrayList<>();
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectEntity> projects = new ArrayList<>();
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienceEntity> experiences;
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private SocialEntity social;

}
