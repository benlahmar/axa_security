package com.example.demo.api.sec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repo.IUser;

@RestController
public class UserAuth {

	@Autowired
	IUser urepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/users")
	public User add(@RequestBody User u)
	{
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		
		return urepo.save(u);
	}
	
	@GetMapping("/hi")
	public String hello()
	{
		return "hello";
	}
	
	@GetMapping("/users")
	public List<User> get()
	{
		return urepo.findAll();
	}
}
