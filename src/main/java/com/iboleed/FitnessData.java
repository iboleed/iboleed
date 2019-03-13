package com.iboleed;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class FitnessData {
    @Id
    private String id;
    private String memberId;
    private Instant date;
    private Integer steps;

    public FitnessData() {
    }

    public FitnessData(String id, String memberId, Instant date, Integer steps) {
        this.id = id;
        this.memberId = memberId;
        this.date = date;
        this.steps = steps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }
}

