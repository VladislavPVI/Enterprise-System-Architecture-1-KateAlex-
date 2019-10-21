package com.labsKateAlex.domain;

import javax.persistence.*;

@Entity
@Table(name = "hobby")
@NamedQuery(name = "Hobby.getAll", query = "SELECT u from Hobby u")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long name;
    private int hoursperweek;
    private int priority;

    public Hobby(Long name, int hoursperweek, int priority) {
        this.name = name;
        this.hoursperweek = hoursperweek;
        this.priority = priority;
    }

    public Hobby() {
    }

    public Long getId() {
        return id;
    }


    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public int getHoursperweek() {
        return hoursperweek;
    }

    public void setHoursperweek(int hoursperweek) {
        this.hoursperweek = hoursperweek;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
