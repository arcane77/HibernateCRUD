package com.example.hibernet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="some_table")
public class SomeClass {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    public SomeClass() { }

    // Getter and setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SomeClass [id=" + id + ", name=" + name + "]";
    }
}
