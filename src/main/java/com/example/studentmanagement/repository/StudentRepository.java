package com.example.studentmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentmanagement.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    Optional<StudentEntity> findByNim(String nim);

    boolean existsByNim(String nim);

    List<StudentEntity> findByFullNameContainingIgnoreCase(String fullName);
}
