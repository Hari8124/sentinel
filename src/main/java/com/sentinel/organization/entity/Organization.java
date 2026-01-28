package com.sentinel.organization.entity;

import com.sentinel.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizations")
public class Organization extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    protected Organization(){
        // JPA needs a default constructor
    }

    public Organization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
