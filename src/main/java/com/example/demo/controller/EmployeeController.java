package com.example.demo.controller;

 
 
 import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employer;
import com.example.demo.service.EmployerService;
 
  @RestController 
  public class EmployeeController {
  
  
  private EmployerService EmpSvc;
  
  public EmployeeController(EmployerService EmpSvc) {
	  this.EmpSvc =  EmpSvc;
  }
  
  @RequestMapping("/hello") 
  public String testMethod() 
  { 
	  return "Hello Yes"; 
  }
 
 @RequestMapping(value = "/save", method = RequestMethod.POST)
  public HttpStatus saveEmployer (@RequestBody Employer emp)
  {
	  return EmpSvc.saveEmployee(emp);
  }
 
 @RequestMapping(value = "/getAll", method = RequestMethod.GET)
 public List<Employer> getAll(){
	
	 return EmpSvc.getAllEmployees();
 }
 
 @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
 public void deleteById(@PathVariable int id) {
	 
	EmpSvc.deleteById(id);
	 
 }
 @RequestMapping(value="/update", method = RequestMethod.PUT)
 public HttpStatus updateEmployee(@RequestBody Employer emp) {
	 return EmpSvc.updateEmployee(emp);
 }
 /*
 @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
 public Employer getById(@PathVariable int id){
	
	 return EmpSvc.getByid(id);
 }*/
 
  }
 