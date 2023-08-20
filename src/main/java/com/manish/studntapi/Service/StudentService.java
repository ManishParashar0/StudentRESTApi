package com.manish.studntapi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.manish.studntapi.entity.Student;
import com.manish.studntapi.repo.StudentRepo;

@Service
public class StudentService implements StudentDao {
	@Autowired
	private StudentRepo repo;

	@Override
	public Student studentadd(Student student) {
		return this.repo.save(student);
	}

	public List<Student> getstudent() {

		return repo.findAll();

	}

	public Optional<Student> findbyid(int id) {

		return this.repo.findById(id);

	}

	public ResponseEntity<Object> update(int id, Student updatedStudent) {
		Optional<Student> findById = repo.findById(id);
		if (findById.isPresent()) {
			Student existingStudent = findById.get();
			// Update the fields of the existing student with values from updatedStudent
			existingStudent.setName(updatedStudent.getName());
			existingStudent.setDisc(updatedStudent.getDisc());
			// ... other fields
			repo.save(existingStudent); // Save the updated student
			return ResponseEntity.ok("Update success");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	public ResponseEntity<Object> delete(int id) {
		Optional<Student> findById = repo.findById(id);
		if (findById.isPresent()) {
			repo.delete(findById.get());
			return ResponseEntity.ok("Delete success");
		}
		return ResponseEntity.notFound().build();

	}
}
