package com.labsKateAlex.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule")
@NamedQuery(name = "Schedule.getAll", query = "SELECT u from Schedule u")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long hobbyid;
    private java.time.LocalDateTime localDateTime;
    private int mark;
    private boolean complete;

    public Schedule(Long hobbyid, LocalDateTime localDateTime) {
        this.hobbyid = hobbyid;
        this.localDateTime = localDateTime;
    }

    public Schedule() {
    }

    public Long getId() {
        return id;
    }

    public Long getHobbyid() {
        return hobbyid;
    }

    public void setHobbyid(Long hobbyid) {
        this.hobbyid = hobbyid;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
