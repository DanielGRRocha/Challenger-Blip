package com.apibot.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apibot.petshop.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
