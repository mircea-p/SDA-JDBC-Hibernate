package com.sda.mirceapopa.hibernate2.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moduleId")
    private Integer moduleId;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;

    @ManyToMany(mappedBy = "moduleList")
    private List<Team> teamList;

    @ManyToOne
    @JoinColumn(name = "classroomId")
    private Classroom classroom;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }



    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleId=" + moduleId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", classroom=" + classroom +
                '}';
    }
}
