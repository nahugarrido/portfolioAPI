package com.portfoliov2.app.portfolioAPI.experience.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Experience")
public class ExperienceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean show;

    private int priority;

    private String img;

    private String company;

    private String position;

    private String description;

    // Date format = "2023-04-04"
    @Column(name = "start_date")
    Date startDate;

    // Date format = "2023-04-04"
    @Column(name = "finish_date")
    Date finishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "person")
    private PersonEntity person;
}
