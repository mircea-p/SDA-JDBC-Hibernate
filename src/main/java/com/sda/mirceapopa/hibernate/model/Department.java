package com.sda.mirceapopa.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments") // mandatory - singular vs plural
public class Department {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id") // optional - identical names
        private Integer id;
        @Column(name = "name") // optional - identical names
        private String name;

        @OneToMany(mappedBy = "department") // aici pun numele clasei din employee
        private List<Employee> employeeList;

        public Integer getId()
        {
            return id;
        }

        public void setId(Integer id)
        {
            this.id = id;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


