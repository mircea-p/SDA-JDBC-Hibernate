package com.sda.mirceapopa.hibernate2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamId")
    private Integer teamId;
    @Column(name = "teamName")
    private String teamName;

    @OneToMany(mappedBy = "team")
    private List<Person> personList;

    @OneToMany(mappedBy = "team")
    private List<Module> moduleList = new ArrayList<>();

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
