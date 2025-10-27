package com.example.studentmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    // Menambahkan student baru
    public void addStudent(Student student) {
        students.add(student);
    }

    // Mengambil semua student
    public List<Student> getAllStudents() {
        return students;
    }
}
