package com.sentinel.oncall.entity;

import com.sentinel.auth.entity.User;
import com.sentinel.common.entity.BaseEntity;
import jakarta.persistence.*;

import javax.print.attribute.standard.MediaSize;
import java.time.Instant;

@Entity
@Table(name = "oncall_schedules")
public class OnCallSchedule extends BaseEntity {

    @ManyToOne(optional = false)
    private OnCallRotation rotation;

    @ManyToOne(optional = false)
    private User engineer;

    @Column(nullable = false)
    private Instant startTime;

    @Column(nullable = false)
    private Instant endTime;

    protected OnCallSchedule(){
        // JPA only
    }

    public OnCallSchedule(OnCallRotation rotation, User engineer, Instant startTime, Instant endTime) {
        this.rotation = rotation;
        this.engineer = engineer;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public User getEngineer(){
        return engineer;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }
}
