package com.okancezik.student.api;

import com.okancezik.student.entity.Student;
import com.okancezik.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentsController {

    private final StudentService studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudents(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }
}
