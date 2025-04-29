package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Lesson;

public interface StudentRepository extends JpaRepository<Lesson, Integer> {

}
