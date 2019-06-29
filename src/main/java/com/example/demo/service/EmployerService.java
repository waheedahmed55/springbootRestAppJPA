package com.example.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.demo.model.Employer;


public interface EmployerService {
	
 HttpStatus saveEmployee (Employer emp);
 List<Employer> getAllEmployees ();
 HttpStatus deleteById(int id);
 HttpStatus updateEmployee (Employer emp);
 //Employer getByid(int id);
}
