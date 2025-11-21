package com.example.studentmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.studentmanagement.domain.Student;
import com.example.studentmanagement.domain.StudentRequest;
import com.example.studentmanagement.entity.StudentEntity;
import com.example.studentmanagement.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private static final int NIM_LENGTH = 5;

    
    public List<Student> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    
    public Student addStudent(StudentRequest request) {

      
        boolean exists = studentRepository.findAll().stream()
                .anyMatch(s ->
                        s.getFullName().equalsIgnoreCase(request.getFullName()) &&
                        s.getDob().equals(request.getDob())
                );

        if (exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data already exists");
        }

        StudentEntity entity = StudentEntity.builder()
                .nim(generateNIM())
                .fullName(request.getFullName())
                .dob(request.getDob())
                .address(request.getAddress())
                .build();

        return toDto(studentRepository.save(entity));
    }

   
    public Student findStudentByNim(String nim) {
        StudentEntity entity = studentRepository.findByNim(nim)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student with NIM " + nim + " not found"));

        return toDto(entity);
    }

    
    public Student updateStudent(String nim, StudentRequest request) {

        StudentEntity entity = studentRepository.findByNim(nim)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student with NIM " + nim + " not found"));

        entity.setFullName(request.getFullName());
        entity.setDob(request.getDob());
        entity.setAddress(request.getAddress());

        return toDto(studentRepository.save(entity));
    }

    public void deleteStudent(String nim) {
        StudentEntity entity = studentRepository.findByNim(nim)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student with NIM " + nim + " not found"));

        studentRepository.delete(entity);
    }


    private String generateNIM() {
        long count = studentRepository.count() + 1;

        String nim;
        do {
            nim = String.format("%0" + NIM_LENGTH + "d", count);
            count++;
        } while (studentRepository.existsByNim(nim));

        return nim;
    }


    private Student toDto(StudentEntity entity) {
        return new Student(
                entity.getNim(),
                entity.getFullName(),
                entity.getDob(),
                entity.getAddress()
        );
    }
}
