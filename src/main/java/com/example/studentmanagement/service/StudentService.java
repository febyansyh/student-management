package com.example.studentmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.domain.Student;
import com.example.studentmanagement.domain.StudentRequest;

@Service
public class StudentService {

    private static final int LENGTH = 5;
    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public Student addStudent(StudentRequest request) {
        Student savedStudent = new Student();
        savedStudent.setNim(generateNIM());
        savedStudent.setFullName(request.getFullName());
        savedStudent.setDob(request.getDob());
        savedStudent.setAddress(request.getAddress());

        students.add(savedStudent);
        return savedStudent;
    }

    private String generateNIM() {
        int maxId = students.size() + 1;
        return String.format("%0" + LENGTH + "d", maxId);
    }

 
    public Student findStudentByNim(String nim) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getNim().equals(nim))
                .findFirst();

        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            throw new RuntimeException("Student with NIM " + nim + " not found");
        }
    }

    
    public Student updateStudent(String nim, StudentRequest request) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getNim().equals(nim))
                .findFirst();

        if (studentOptional.isPresent()) {
            Student studentToUpdate = studentOptional.get();
            studentToUpdate.setFullName(request.getFullName());
            studentToUpdate.setDob(request.getDob());
            studentToUpdate.setAddress(request.getAddress());
            return studentToUpdate;
        } else {
            throw new RuntimeException("Student with NIM " + nim + " not found");
        }
    }

   
    public void deleteStudent(String nim) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getNim().equals(nim))
                .findFirst();

        if (studentOptional.isPresent()) {
            students.remove(studentOptional.get());
        } else {
            throw new RuntimeException("Student with NIM " + nim + " not found");
        }
    }
}
