package com.portfoliov2.app.portfolioAPI.experience.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "experience")
public class ExperienceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean hidden;

    private String image;

    private String company;

    private String position;

    private String description;

    // Date format = "2023-04-04"
    @Column(name = "start_date")
    private LocalDate startDate;

    // Date format = "2023-04-04"
    @Column(name = "finish_date")
    private LocalDate finishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "person_id")
    private PersonEntity person;
}
