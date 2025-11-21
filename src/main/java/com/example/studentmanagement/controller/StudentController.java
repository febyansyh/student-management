package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.domain.Student;
import com.example.studentmanagement.domain.StudentRequest;
import com.example.studentmanagement.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{nim}")
    public Student getStudentByNim(@PathVariable String nim) {
        return studentService.findStudentByNim(nim);
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.addStudent(studentRequest);
    }

    @PutMapping("/{nim}")
    public Student updateStudent(@PathVariable String nim, @RequestBody StudentRequest request) {
        return studentService.updateStudent(nim, request);
    }

    @DeleteMapping("/{nim}")
    public String removeStudent(@PathVariable String nim) {
        studentService.deleteStudent(nim);
        return "Student deleted successfully!";
    }
}
