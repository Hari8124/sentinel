package com.sentinel.incident.entity;


import com.sentinel.auth.entity.User;
import com.sentinel.common.entity.BaseEntity;
import com.sentinel.incident.model.IncidentEventType;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "incident_events")
public class IncidentEvent extends BaseEntity {

    @ManyToOne(optional = false)
    private Incident incident;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncidentEventType type;

    @ManyToOne
    private User actor;

    @Column(nullable = false)
    private Instant occuredAt;

    @Column(length = 2000)
    private String notes;

    protected IncidentEvent() {
        // JPA only
    }

    public IncidentEvent(Incident incident, IncidentEventType type, User actor, String notes) {
        this.incident = incident;
        this.type = type;
        this.actor = actor;
        this.notes = notes;
        this.occuredAt = Instant.now();
    }

    public IncidentEventType getType(){
        return type;
    }

    public Instant getOccuredAt() {
        return occuredAt;
    }

    public String getNotes() {
        return notes;
    }
}
