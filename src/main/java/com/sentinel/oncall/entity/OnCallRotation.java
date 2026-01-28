package com.sentinel.oncall.entity;


import com.sentinel.common.entity.BaseEntity;
import com.sentinel.team.entity.Team;
import jakarta.persistence.*;

@Entity
@Table(name = "oncall_rotations")
public class OnCallRotation extends BaseEntity {

    @OneToOne(optional = false)
    private Team team;

    @Column(nullable = false)
    private String name;

    protected OnCallRotation() {
        // JPA only
    }

    public OnCallRotation(Team team, String name){
        this.team = team;
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public String getName(){
        return name;
    }
}
