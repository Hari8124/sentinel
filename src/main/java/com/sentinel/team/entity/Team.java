package com.sentinel.team.entity;


import com.sentinel.common.entity.BaseEntity;
import com.sentinel.organization.entity.Organization;
import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Organization organization;

    protected Team() {
        // JPA only
    }

    public Team(String name, Organization organization){
        this.name = name;
        this.organization = organization;
    }

    public String getName(){
        return name;
    }

    public Organization getOrganization(){
        return organization;
    }
}
