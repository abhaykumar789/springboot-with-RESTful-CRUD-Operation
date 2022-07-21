package com.cgi.main.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.stereotype.Service;

import com.cgi.main.EmsappApplication;
import com.cgi.main.entity.Employee;
import com.cgi.main.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private static Logger log=LoggerFactory.getLogger(EmsappApplication.class);
	
	@Autowired
	private EmployeeRepository erepo;

	public void saveEmployee(Employee employee) {
		log.info("EMPLOYEEINFO-"+employee);
		this.erepo.save(employee);
		log.info("DATA-STORE");
	}

	public List<Employee> getAllEmployees() {
		List<Employee> list = this.erepo.findAll();

		return list;
	}

	public void deleteById(int id) {
		this.erepo.deleteById(id);
	}

	public void updateEmployee(Employee employee) {

		this.erepo.save(employee);
	}

	public Employee getEmployeeById(int id) {
		Optional<Employee> op = this.erepo.findById(id);
		if (op.isPresent())
			return op.get();
		else
			return null;
	
	}
	

}
