package com.okancezik.school.service.impl;

import com.okancezik.school.client.StudentClient;
import com.okancezik.school.entity.School;
import com.okancezik.school.repository.SchoolRepository;
import com.okancezik.school.responses.FullSchoolResponse;
import com.okancezik.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;

    @Override
    public void save(School school) {
        repository.save(school);
    }

    @Override
    public List<School> findAllSchools() {
        return repository.findAll();
    }

    @Override
    public FullSchoolResponse findSchoolsWithStudent(int schoolId) {
        var school = repository.findById(schoolId).orElse(
                School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build()
        );
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
