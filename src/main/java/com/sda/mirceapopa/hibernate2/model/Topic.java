package com.sda.mirceapopa.hibernate2.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topics_id")
    private Integer topics_id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "topic")
    private Set<Module> moduleSet;

    public Topic(String name) {
        this.name = name;
    }

    public Topic() {
    }

    public Integer getTopics_id() {
        return topics_id;
    }

    public void setTopics_id(Integer topics_id) {
        this.topics_id = topics_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Module> getModuleSet() {
        return moduleSet;
    }

    public void setModuleSet(Set<Module> moduleSet) {
        this.moduleSet = moduleSet;
    }

    @Override
    public String toString() {
        return "Topics{" +
                "topics_id=" + topics_id +
                ", name='" + name + '\'' +
                '}';
    }
}
