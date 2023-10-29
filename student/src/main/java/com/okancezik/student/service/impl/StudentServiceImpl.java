package com.okancezik.student.service.impl;

import com.okancezik.student.entity.Student;
import com.okancezik.student.repository.StudentRepository;
import com.okancezik.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @Override
    public List<Student> findAllStudentsBySchool(int schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }
}
