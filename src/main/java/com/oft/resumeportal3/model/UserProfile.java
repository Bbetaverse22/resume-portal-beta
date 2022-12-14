package com.oft.resumeportal3.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int theme;
    private String summary;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String designation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "job_id")
    List<Job> jobs = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "education_id")
    List<Education> educations = new ArrayList<>();

    @ElementCollection(targetClass = String.class)
    List<String> skills = new ArrayList<>();
}
