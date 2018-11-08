package com.matmazur.springaopintro.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;public class Person {

    @NotNull
    @Min(2)
    private String name;
    @NotNull
    @Min(2)
    private String surname;
    @NotNull
    @Min(0)
    private Long id;


    public Person(String name, String surname, Long id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
