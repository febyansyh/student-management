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

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    
    @GetMapping("/{nim}")
    public Object getStudentByNim(@PathVariable String nim) {
        try {
            return studentService.findStudentByNim(nim);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.addStudent(studentRequest);
    }

    @PutMapping("/{nim}")
    public Object updateStudent(@PathVariable String nim, @RequestBody StudentRequest request) {
        try {
            return studentService.updateStudent(nim, request);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/{nim}")
    public String removeStudent(@PathVariable String nim) {
        try {
            studentService.deleteStudent(nim);
            return "Successfully deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
