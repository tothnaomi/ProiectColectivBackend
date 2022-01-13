package com.SAPFeedback2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "pegs")
public class PEG {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    /**
     * status can be open or sent or pending
     * 0 - open
     * 1 - sent
     * 2 - pending
     */
    @Column(name = "status")
    private Integer status;

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

    public PEG( String text, Integer firstName, String strategy_focus, String customer_focus, String employee_focus, String excellence_focus, String professional_industry_experience, String project_and_program_management, String average, Project project) {
        this.text = text;
        this.status = firstName;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStrategy_focus() {
        return strategy_focus;
    }

    public void setStrategy_focus(String strategy_focus) {
        this.strategy_focus = strategy_focus;
    }

    public String getCustomer_focus() {
        return customer_focus;
    }

    public void setCustomer_focus(String customer_focus) {
        this.customer_focus = customer_focus;
    }

    public String getEmployee_focus() {
        return employee_focus;
    }

    public void setEmployee_focus(String employee_focus) {
        this.employee_focus = employee_focus;
    }

    public String getExcellence_focus() {
        return excellence_focus;
    }

    public void setExcellence_focus(String excellence_focus) {
        this.excellence_focus = excellence_focus;
    }

    public String getProfessional_industry_experience() {
        return professional_industry_experience;
    }

    public void setProfessional_industry_experience(String professional_industry_experience) {
        this.professional_industry_experience = professional_industry_experience;
    }

    public String getProject_and_program_management() {
        return project_and_program_management;
    }

    public void setProject_and_program_management(String project_and_program_management) {
        this.project_and_program_management = project_and_program_management;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "PEG{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", status=" + status +
                ", manager=" + manager +
                ", employee=" + employee +
                ", strategy_focus='" + strategy_focus + '\'' +
                ", customer_focus='" + customer_focus + '\'' +
                ", employee_focus='" + employee_focus + '\'' +
                ", excellence_focus='" + excellence_focus + '\'' +
                ", professional_industry_experience='" + professional_industry_experience + '\'' +
                ", project_and_program_management='" + project_and_program_management + '\'' +
                ", average='" + average + '\'' +
                ", project=" + project +
                '}';
    }
}
