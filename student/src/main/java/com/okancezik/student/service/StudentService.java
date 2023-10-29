package com.okancezik.student.service;

import com.okancezik.student.entity.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);

    List<Student> findAllStudents();

    List<Student> findAllStudentsBySchool(int schoolId);

}
