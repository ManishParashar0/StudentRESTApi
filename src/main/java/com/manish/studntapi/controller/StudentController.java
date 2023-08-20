package com.manish.studntapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manish.studntapi.Service.StudentService;
import com.manish.studntapi.entity.Student;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping("/add")
	public ResponseEntity<Student> createstudent(@RequestBody Student student) {
		return new ResponseEntity<>(this.service.studentadd(student), HttpStatus.CREATED);

	}

	@GetMapping("/get")
	public List<Student> get(@RequestBody Student student) {
		return this.service.getstudent();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Student> findbyid(@PathVariable("id") int id) {
		Optional<Student> findbyid = this.service.findbyid(id);
		if (findbyid.isPresent()) {
			return ResponseEntity.ok(findbyid.get());
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Student updatedStudent) {
		return service.update(id, updatedStudent);

	}

}
