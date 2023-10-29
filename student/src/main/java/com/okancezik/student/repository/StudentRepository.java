package com.okancezik.student.repository;

import com.okancezik.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllBySchoolId(int schoolId);
}
