package com.sentinel.oncall.repository;

import com.sentinel.oncall.entity.OnCallSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public interface OnCallScheduleRepository extends JpaRepository<OnCallSchedule, UUID> {
    Optional<OnCallSchedule> findFirstByRotation_Team_IdAndStartTimeBeforeAndEndTimeAfter(
            UUID teamId,
            Instant now1,
            Instant now2
    );
}
