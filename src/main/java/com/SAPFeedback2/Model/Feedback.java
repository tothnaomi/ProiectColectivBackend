package com.SAPFeedback2.Model;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Column(name = "text")
    private String text;

    /**
     * An employee can check whether he wants his name visible or not
     */
    @Column(name = "anonymity")
    private boolean anonymity;

    @Column(name = "technical_skills")
    private String technical_skills;

    @Column(name = "soft_skills")
    private String soft_skills;

    @Column(name = "communication_skills")
    private String communication_skills;

    @Column(name = "average")
    private String average;

    @ManyToOne
    @JoinColumn(name = "employee1_id", referencedColumnName = "personalNumber")
    private Employee employee1;

    @ManyToOne
    @JoinColumn(name = "employee2_id", referencedColumnName = "personalNumber")
    private Employee employee2;

    public Feedback() {
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", anonymity=" + anonymity +
                ", technical_skills='" + technical_skills + '\'' +
                ", soft_skills='" + soft_skills + '\'' +
                ", communication_skills='" + communication_skills + '\'' +
                ", average='" + average + '\'' +
                ", employee1=" + employee1 +
                ", employee2=" + employee2 +
                '}';
    }

    public Feedback( String text, boolean anonymity, String technical_skills, String soft_skills, String communication_skills, String average) {
        this.text = text;
        this.anonymity = anonymity;
        this.technical_skills = technical_skills;
        this.soft_skills = soft_skills;
        this.communication_skills = communication_skills;
        this.average = average;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAnonymity() {
        return anonymity;
    }

    public void setAnonymity(boolean anonymity) {
        this.anonymity = anonymity;
    }

    public String getTechnical_skills() {
        return technical_skills;
    }

    public void setTechnical_skills(String technical_skills) {
        this.technical_skills = technical_skills;
    }

    public String getSoft_skills() {
        return soft_skills;
    }

    public void setSoft_skills(String soft_skills) {
        this.soft_skills = soft_skills;
    }

    public String getCommunication_skills() {
        return communication_skills;
    }

    public void setCommunication_skills(String communication_skills) {
        this.communication_skills = communication_skills;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Employee getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }

}
