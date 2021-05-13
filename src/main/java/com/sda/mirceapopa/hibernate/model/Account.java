package com.sda.mirceapopa.hibernate.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "creationDate")
    private Date creationDate;
    @OneToOne(mappedBy = "account") // account este numele field-ului din Employee.
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                '}';
    }
}
