package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employer;
import com.example.demo.repository.EmployerRepository;

@Service
public class EmployerServiceImpl implements EmployerService{

	
	private EmployerRepository EmpRepo;
	@Autowired
	public EmployerServiceImpl (EmployerRepository EmpRepo) {
		this.EmpRepo = EmpRepo;
	}
	
	@Override
	public HttpStatus saveEmployee(Employer emp) {
		try {
			EmpRepo.save(emp);
			return HttpStatus.OK;
		}catch(Exception ex) {
			return HttpStatus.BAD_REQUEST;
		}
	}

	@Override
	public List<Employer> getAllEmployees() {

	
		return EmpRepo.findAll();
	}

	@Override
	public HttpStatus deleteById(int id) {
		try {
			EmpRepo.deleteById(id);
			return HttpStatus.OK;
		}catch(Exception ex)
		{
			return HttpStatus.BAD_REQUEST;
		}
	}

	@Override
	public HttpStatus updateEmployee(Employer emp) {
		try {
			EmpRepo.save(emp);
			return HttpStatus.OK;
		}catch(Exception ex) {
			return HttpStatus.BAD_REQUEST;
		}
	}

	/*
	@Override
	public Employer getByid(int id) {
			
			List<Employer> emp = EmpRepo.findAll();
	
			for (Employer emps : emp) {
		        if (emps.getEmplId()==id) {
		            return emps;
		        }
		    }
			return null;
	}*/
	

	
	

}
