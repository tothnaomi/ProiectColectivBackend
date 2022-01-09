package com.SAPFeedback2.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private Long personalNumber;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "careerLevel")
    private String careerlevel;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "logged_in")
    private int loggedIn;

    /**
     * status 0 - user
     * status 1 - manager
     * status 2 - admin
     */
    @Column(name = "status")
    private Integer status;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "employee_team",
            joinColumns = {@JoinColumn(name = "personal_number")},
            inverseJoinColumns = {@JoinColumn(name = "team_id")}
    )
    private List<Team> teams = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "employee_project",
            joinColumns = {@JoinColumn(name = "personal_number")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")}
    )
    private List<Project> projects = new ArrayList<>();

    // standard constructors
    public Employee() {
    }

    public Employee(Long personalNumber, String firstName, String lastName, String email, String username, String password, Integer status) {
        this.personalNumber = personalNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.status = status;
        this.loggedIn = 0;
    }

    public Employee(String firstname, String lastname, String email, Integer status, String careerlevel, Long personalNumber) {
        this.personalNumber = personalNumber;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.status = status;
        this.loggedIn = 0;
    }


    // standard getters and setters

    public String getCareerlevel() {
        return careerlevel;
    }

    public void setCareerlevel(String careerlevel) {
        this.careerlevel = careerlevel;
    }

    public int getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(int loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Long personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}