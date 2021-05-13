package com.sda.mirceapopa.hibernate.model;


import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    private Integer projectId;
    @Column(name = "name")
    private String name;
    @Transient // ii spune la hibernate sa nu se lege de el, sa-l ignore
    private double budget;
    @Transient
    private String currency;
    @Enumerated(EnumType.STRING) // special pt enumuri, tipul: String sau Ordinal, se recomanda String.
    @Column(name = "type")
    private ProjectType projectType;


    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                '}';
    }
}
