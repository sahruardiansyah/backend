package com.sahru.assginment.controller;

import com.sahru.assginment.dao.CustomerDAO;
import com.sahru.assginment.model.Customer;
import com.sahru.assginment.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerRestController {

	
	@Autowired
	private CustomerDAO customerDAO;


	@GetMapping("/customers")
	public ResponseEntity getCustomer(@RequestBody Request req) {

		Customer customer = customerDAO.get(req.getAge());
		if (customer.getAge()<=20){
			customer.setBackground("Light Blue");
			return new ResponseEntity(customer, HttpStatus.OK);
		}
		if (customer.getAge()>=21 && customer.getAge() <=50){
			customer.setBackground("Light Red");
			return new ResponseEntity(customer, HttpStatus.OK);
		}
		if (customer.getAge()>50){
			customer.setBackground("Grey");
			return new ResponseEntity(customer, HttpStatus.OK);
		}

		if (customer == null) {
			return new ResponseEntity("No Customer found for age " + req.getAge(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@PostMapping(value = "/customers")
	public ResponseEntity createCustomer(@RequestBody Customer customer) {

		customerDAO.create(customer);
		if (customer.getAge()<=20){
			customer.setBackground("Light Blue");
			return new ResponseEntity(customer, HttpStatus.OK);
		}
		if (customer.getAge()>=21 && customer.getAge() <=50){
			customer.setBackground("Light Red");
			return new ResponseEntity(customer, HttpStatus.OK);
		}
		if (customer.getAge()>50){
			customer.setBackground("grey");
			return new ResponseEntity(customer, HttpStatus.OK);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@GetMapping("/customersList")
	public List getCustomers() {
		return customerDAO.list();
	}


}