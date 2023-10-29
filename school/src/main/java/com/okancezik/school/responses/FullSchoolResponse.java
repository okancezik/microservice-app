package com.okancezik.school.responses;

import com.okancezik.school.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullSchoolResponse {

    private String name;

    private String email;

    private List<Student> students;
}
