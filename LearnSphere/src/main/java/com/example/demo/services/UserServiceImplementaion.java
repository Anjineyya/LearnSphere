package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImplementaion implements UserService{

		@Autowired
		UserRepository repo;
		
		@Override
		public String addUser(Users user) {
			repo.save(user);
			return "student added successfully!";
		}
		@Override
		public boolean checkEmail(String email) {
			return repo.existsByEmail(email);
		}
		@Override
		public boolean validate(String email, String password) {
			if(repo.existsByEmail(email)) {
				Users u=repo.getByEmail(email);
				String dbPassword=u.getPassword();
				if(password.equals(dbPassword)) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		@Override
		public String checkRole(String email) {
			
			Users u=repo.getByEmail(email);
			
			String r=u.getRole();
			
			return r;
		}
	}

