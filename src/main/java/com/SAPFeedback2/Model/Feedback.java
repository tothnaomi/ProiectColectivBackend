package com.SAPFeedback2.Model;

import javax.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
