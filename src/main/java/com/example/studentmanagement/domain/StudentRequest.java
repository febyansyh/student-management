package com.example.studentmanagement.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    private String fullName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private String address;
}
