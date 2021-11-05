package com.SAPFeedback2.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "personalNumber")
    private Employee manager;

    @ManyToMany(mappedBy = "teams")
    private List<Employee> employees = new ArrayList<>();

    public Team() {
    }
}
