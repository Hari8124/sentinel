package com.sentinel.incident.service;

import com.sentinel.auth.entity.User;
import com.sentinel.incident.entity.Incident;
import com.sentinel.incident.model.Severity;
import com.sentinel.incident.repository.IncidentRepository;
import com.sentinel.service.entity.ProductionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class    IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository){
        this.incidentRepository = incidentRepository;
    }

    public Incident createIncident(ProductionService productionService, String title, String description, Severity severity){
        Incident incident = new Incident(productionService, title, description, severity);
        return incidentRepository.save(incident);
    }

    public Incident acknowledgeIncident(UUID incidentId, User engineer){
        Incident incident = incidentRepository.findById(incidentId).orElseThrow(() -> new RuntimeException("Incident not found"));
        incident.acknowledge(engineer);
        return incidentRepository.save(incident);
    }

    public Incident resolveIncident(UUID incidentId, User engineer){
        Incident incident = incidentRepository.findById(incidentId).orElseThrow(() -> new RuntimeException("Incident not found"));
        incident.resolve(engineer);
        return incidentRepository.save(incident);
    }
}
