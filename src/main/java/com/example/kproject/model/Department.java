package com.example.kproject.model;

import javax.persistence.*;

@Entity
@Table(name = "U_Department")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {

    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "floor", nullable = false)
    private Long floor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFloor() {
        return floor;
    }

    public void setFloor(Long floor) {
        this.floor = floor;
    }
}
