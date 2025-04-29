package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Comments;
import com.example.demo.entity.Users;
import com.example.demo.services.CommentServices;
import com.example.demo.services.UserService;

@Controller
public class ServiceController {
	@Autowired
	UserService uService;
	
	@Autowired
	CommentServices cService;
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam("name")String name,
			@RequestParam("email")String email,
			@RequestParam("password")String password,
			@RequestParam("role")String role) {
		boolean emailExist=uService.checkEmail(email);
		if(emailExist==false) {
			Users user = new Users();
			
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);
			uService.addUser(user);
			
			System.out.println("User registerd succesfully");
			return "redirect:/login";
		}else {
			System.out.println("User already exist");
			return "redirect:/register";
		}
		  
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email")String email,
				@RequestParam("password")String password) {
		boolean val=uService.validate(email, password);
		if(val==true) {
				
			String role=uService.checkRole(email);
			System.out.println(role);
			if(role.equals("student")) {
				System.out.println("Student login successful!");
				return "studentHome";
			}else {
				System.out.println("trainer login succesfully");
				return "trainerHome";
			}
					
		}
		else{
			System.out.println("incorrect credentials, try again!");
			return "login";
		}
	}
	@PostMapping("/addComment")
	public String comment(@RequestParam("comment")String comment, Model model) {
		Comments c=new Comments();
		c.setComments(comment);
		cService.addComment(c);
		return "redirect:/";
	} 
}

