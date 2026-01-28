package com.sentinel.incident.repository;

import com.sentinel.incident.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncidentRepository extends JpaRepository<Incident, UUID> {
}
