package com.sentinel.incident.entity;


import com.sentinel.auth.entity.User;
import com.sentinel.common.entity.BaseEntity;
import com.sentinel.incident.model.IncidentStatus;
import com.sentinel.incident.model.Severity;
import com.sentinel.service.entity.Service;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "incidents")
public class Incident extends BaseEntity {

    @ManyToOne(optional = false)
    private Service service;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncidentStatus status;

    private Instant acknowledgedAt;
    private Instant resolvedAt;

    @ManyToOne
    private User acknowledgedBy;

    @ManyToOne
    private User resolvedBy;

    protected Incident() {
        // JPA only
    }

    public Incident(Service service, String title, String description, Severity severity){
        this.service = service;
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = IncidentStatus.OPEN;
    }

    public void acknowledge(User engineer) {
        if(this.status != IncidentStatus.OPEN) {
            throw new IllegalStateException("Incident cannot be acknowledged twice.");
        }

        this.status = IncidentStatus.ACKNOWLEDGED;
        this.acknowledgedAt = Instant.now();
        this.acknowledgedBy = engineer;
    }

    public void resolve(User engineer) {
        if(this.status != IncidentStatus.ACKNOWLEDGED){
            throw new IllegalStateException("Incident must be acknowledged before resolving.");
        }

        this.status = IncidentStatus.RESOLVED;
        this.resolvedAt = Instant.now();
        this.resolvedBy = engineer;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public Severity getSeverity(){
        return severity;
    }

    public String getTitle() {
        return title;
    }
}
