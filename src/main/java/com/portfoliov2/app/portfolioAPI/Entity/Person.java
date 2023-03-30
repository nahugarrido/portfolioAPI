package com.portfoliov2.app.portfolioAPI.Entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/// I'm using @Table and @Column as a good practice
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "seniority")
    private String seniority;

    @Column(name = "description")
    private String description;

    @Column(name = "profileImg")
    private String profileImg;

    /// save the ids of the svg images that should be displayed in the portfolio
    @Column(name = "skills")
    private ArrayList<Integer> skills;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> educations = new ArrayList<>();
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects = new ArrayList<>();
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experience> experiences;
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Social social;

    public ArrayList<Integer> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Integer> skills) {
        this.skills = skills;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSeniority() {
        return seniority;
    }

    public String getDescription() {
        return description;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
}
