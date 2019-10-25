package com.labsKateAlex.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hobby")
@NamedQuery(name = "Hobby.getAll", query = "SELECT u from Hobby u")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private int hoursperweek;
    private int priority;

    public Hobby(String name, int hoursperweek, int priority) {
        this.name = name;
        this.hoursperweek = hoursperweek;
        this.priority = priority;
    }


    public Hobby() {
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
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
