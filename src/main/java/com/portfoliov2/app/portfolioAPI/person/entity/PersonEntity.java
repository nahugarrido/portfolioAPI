package com.portfoliov2.app.portfolioAPI.person.entity;
import com.portfoliov2.app.portfolioAPI.education.entity.EducationEntity;
import com.portfoliov2.app.portfolioAPI.experience.entity.ExperienceEntity;
import com.portfoliov2.app.portfolioAPI.work.entity.WorkEntity;
import jakarta.persistence.*;
import lombok.*;

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

    private String github;

    private String linkedin;

    private String email;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EducationEntity> educations;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkEntity> projects;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienceEntity> experiences;
}
