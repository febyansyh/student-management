package com.example.studentmanagement.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String nim;
    private String fullName;
    private LocalDate dob;
    private String address;
}
