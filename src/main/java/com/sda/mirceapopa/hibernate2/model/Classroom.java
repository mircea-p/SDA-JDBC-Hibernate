package com.sda.mirceapopa.hibernate2.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroomId")
    private Integer classroomId;
    @Column(name = "name")
    private String name;
    @Column(name = "adress")
    private String adress;

    @OneToMany(mappedBy = "classroom")
    private List<Module> moduleList;

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId=" + classroomId +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", moduleList=" + moduleList +
                '}';
    }
}
