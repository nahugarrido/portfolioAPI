package com.portfoliov2.app.portfolioAPI.social.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import jakarta.persistence.*;

/// I'm using @Table and @Column as a good practice
@Entity
@Table(name = "Social")
public class SocialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "github")
    private String github;
    @Column(name = "linkedin")
    private String linkedin;
    @Column(name = "instagram")
    private String instagram;
    @Column(name = "twitter")
    private String twitter;

    @OneToOne(fetch = FetchType.LAZY)
    // @MapsId
    @JsonIgnore
    @JoinColumn(name = "person_id")
    PersonEntity person;
    public SocialEntity() {

    }

    public Long getId() {
        return id;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

}
