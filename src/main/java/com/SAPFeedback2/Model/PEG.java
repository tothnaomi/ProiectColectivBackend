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
//    @Column(name = "fk_manager")
    private Employee manager;

    @ManyToOne
//    @Column(name = "fk_employee")
    private Employee employee;

    @Column(name = "crit1")
    private String crit1;

    @Column(name = "crit2")
    private String crit2;

    @Column(name = "crit3")
    private String crit3;

    @Column(name = "crit4")
    private String crit4;

    @Column(name = "crit5")
    private String crit5;

    @Column(name = "crit6")
    private String crit6;

    @Column(name = "crit7")
    private String crit7;

    @Column(name = "average")
    private String average;

    @ManyToOne
//    @Column(name = "fk_project")
    private Project project;


    public PEG(Long id, String text, Integer firstName, Employee manager, Employee employee, String crit1, String crit2, String crit3, String crit4, String crit5, String crit6, String crit7, String average, Project project) {
        this.id = id;
        this.text = text;
        this.firstName = firstName;
        this.manager = manager;
        this.employee = employee;
        this.crit1 = crit1;
        this.crit2 = crit2;
        this.crit3 = crit3;
        this.crit4 = crit4;
        this.crit5 = crit5;
        this.crit6 = crit6;
        this.crit7 = crit7;
        this.average = average;
        this.project = project;
    }

    public PEG() {
    }
}
