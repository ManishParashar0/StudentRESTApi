package com.manish.studntapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.studntapi.entity.Student;
import com.manish.studntapi.repo.StudentRepo;

@Service
public class StudentService implements StudentDao {
	@Autowired
	private StudentRepo repo;

	@Override
	public Student studentadd(Student student) {
		Student save = this.repo.save(student);

		return save;

	}

	public List<Student> getstudent() {

		return repo.findAll();

	}

}
