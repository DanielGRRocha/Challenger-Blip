package com.apibot.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apibot.petshop.entities.Schedule;
import com.apibot.petshop.repositories.ScheduleRepository;
import com.apibot.petshop.services.exception.ResourceNotFoundException;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository repository;

	public List<Schedule> findAll() {
		return repository.findAll();
	}

	public Schedule findById(Long id) {
		Optional<Schedule> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Schedule insert(Schedule obj) {
		return repository.save(obj);
	}

}
