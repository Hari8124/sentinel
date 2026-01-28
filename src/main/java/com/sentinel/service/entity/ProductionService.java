package com.sentinel.service.entity;


import com.sentinel.common.entity.BaseEntity;
import com.sentinel.team.entity.Team;
import jakarta.persistence.*;
@Entity
@Table(name = "services")
public class ProductionService extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(optional = false)
    private Team owningTeam;

    protected ProductionService(){
        // JPA only
    }

    public ProductionService(String name, Team owningTeam){
        this.name = name;
        this.owningTeam = owningTeam;
    }

    public String getName(){
        return name;
    }

    public Team getOwningTeam(){
        return owningTeam;
    }
}
