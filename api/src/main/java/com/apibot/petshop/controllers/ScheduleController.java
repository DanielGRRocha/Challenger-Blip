package com.apibot.petshop.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apibot.petshop.entities.Schedule;
import com.apibot.petshop.services.ScheduleService;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {

	@Autowired
	private ScheduleService service;

	@GetMapping
	public ResponseEntity<List<Schedule>> findAll() {
		List<Schedule> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Schedule> findById(@PathVariable Long id) {
		Schedule obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Schedule> insert(@RequestBody Schedule obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
