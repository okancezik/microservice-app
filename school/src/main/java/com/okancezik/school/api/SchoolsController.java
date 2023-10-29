package com.okancezik.school.api;

import com.okancezik.school.entity.School;
import com.okancezik.school.responses.FullSchoolResponse;
import com.okancezik.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/school")
public class SchoolsController {

    private final SchoolService schoolService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody School school){
        log.info(school.getId()+"ID GELDİ");
        schoolService.save(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools(){
        return ResponseEntity.ok(schoolService.findAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllSchools(@PathVariable("school-id") int schoolId){
        return ResponseEntity.ok(schoolService.findSchoolsWithStudent(schoolId));
    }
}
