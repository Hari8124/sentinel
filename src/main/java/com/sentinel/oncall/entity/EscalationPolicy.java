package com.sentinel.oncall.entity;


import com.sentinel.auth.entity.User;
import com.sentinel.common.entity.BaseEntity;
import com.sentinel.team.entity.Team;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "escalation_policies")
public class EscalationPolicy extends BaseEntity {

    @OneToOne(optional = false)
    private Team team;

    @Column(nullable = false)
    private int ackTimeoutMinutes;

    @ManyToMany
    @JoinTable(
            name = "escalation_order",
            joinColumns = @JoinColumn(name = "policy_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> escalationOrder = new ArrayList<>();

    protected EscalationPolicy() {
        // JPA only
    }

    public EscalationPolicy(Team team, int ackTimeoutMinutes, List<User> escalationOrder){
        this.team = team;
        this.ackTimeoutMinutes = ackTimeoutMinutes;
        this.escalationOrder = escalationOrder;
    }

    public int getAckTimeoutMinutes(){
        return ackTimeoutMinutes;
    }

    public List<User> getEscalationOrder(){
        return escalationOrder;
    }

}
