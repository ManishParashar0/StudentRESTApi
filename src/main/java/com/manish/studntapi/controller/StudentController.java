package com.manish.studntapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manish.studntapi.Service.StudentService;
import com.manish.studntapi.entity.Student;

@RestController
public class StudentController {
//	@Autowired
//	private Student student;
	@Autowired
	private StudentService service;

	@PostMapping("/add")
	public ResponseEntity<Student> createstudent(@RequestBody Student student) {
		Student studentadd = this.service.studentadd(student);
		return new ResponseEntity<>(studentadd, HttpStatus.CREATED);

	}

	@GetMapping("/get")
	public List<Student> get(@RequestBody Student student) {
		List<Student> getstudent = this.service.getstudent();

		return getstudent;

	}
}
