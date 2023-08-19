package com.manish.studntapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.studntapi.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
