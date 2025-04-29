package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Lesson;
import com.example.demo.repository.LessonRepository;

@Service
public class StudentServiceImplementaion implements StudentService {
    @Autowired
    LessonRepository lessonRepo;
	@Override
	public Lesson getLesson(int lessonId) {
		return lessonRepo.findById(lessonId).get();
	}

}
