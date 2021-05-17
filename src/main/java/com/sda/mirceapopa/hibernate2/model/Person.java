package com.sda.mirceapopa.hibernate2.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personId")
    private Integer personId;
    @Column(name = "firtsName")
    private String firstName;
    @Column(name = "lastName")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    @Column(name = "isTrainer")
    private IsTrainer isTrainer;
    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public IsTrainer getIsTrainer() {
        return isTrainer;
    }

    public void setIsTrainer(IsTrainer isTrainer) {
        this.isTrainer = isTrainer;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", isTrainer=" + isTrainer +
                '}';
    }
}
