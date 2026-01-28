package com.sentinel.auth.entity;

import com.sentinel.auth.model.Role;
import com.sentinel.common.entity.BaseEntity;
import com.sentinel.organization.entity.Organization;
import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ManyToOne(optional = false)
    private Organization organization;

    protected User(){
        // JPA only
    }

    public User(String email, String passwordHash, Role role, Organization organization){
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.organization = organization;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public Organization getOrganization() {
        return organization;
    }
}
