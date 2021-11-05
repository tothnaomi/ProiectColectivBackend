package com.SAPFeedback2.Model;

import javax.persistence.*;

@Entity
@Table(name = "pegs")
public class PEG {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "status")
    private Integer firstName;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "personalNumber")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "personalNumber")
    private Employee employee;

    @Column(name = "strategy_focus")
    private String strategy_focus;

    @Column(name = "customer_focus")
    private String customer_focus;

    @Column(name = "employee_focus")
    private String employee_focus;

    @Column(name = "excellence_focus")
    private String excellence_focus;

    @Column(name = "professional_industry_experience")
    private String professional_industry_experience;

    @Column(name = "project_and_program_management")
    private String project_and_program_management;

    @Column(name = "average")
    private String average;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    public PEG(Long id, String text, Integer firstName, Employee manager, Employee employee, String strategy_focus, String customer_focus, String employee_focus, String excellence_focus, String professional_industry_experience, String project_and_program_management, String average, Project project) {
        this.id = id;
        this.text = text;
        this.firstName = firstName;
        this.manager = manager;
        this.employee = employee;
        this.strategy_focus = strategy_focus;
        this.customer_focus = customer_focus;
        this.employee_focus = employee_focus;
        this.excellence_focus = excellence_focus;
        this.professional_industry_experience = professional_industry_experience;
        this.project_and_program_management = project_and_program_management;
        this.average = average;
        this.project = project;
    }

    public PEG() {
    }
}
