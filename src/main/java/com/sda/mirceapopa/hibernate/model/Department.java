package com.sda.mirceapopa.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "departments") // mandatory - singular vs plural
public class Department {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id") // optional - identical names
        private Integer id;
        @Column(name = "name") // optional - identical names
        private String name;
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
    }


