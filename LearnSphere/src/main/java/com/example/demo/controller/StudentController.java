package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Lesson;
import com.example.demo.services.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService service;
	@PostMapping("/goToLesson")
	public String myLesson(@RequestParam("lessonId")int lessonId, Model model) {
		
		Lesson lesson=service.getLesson(lessonId);
		
		model.addAttribute("lesson",lesson);
		System.out.println(lesson);
		return "myLesson";
	}

}
