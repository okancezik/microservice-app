package com.okancezik.school.service;

import com.okancezik.school.entity.School;
import com.okancezik.school.responses.FullSchoolResponse;

import java.util.List;

public interface SchoolService {
    void save(School school);

    List<School> findAllSchools();

    FullSchoolResponse findSchoolsWithStudent(int schoolId);
}
