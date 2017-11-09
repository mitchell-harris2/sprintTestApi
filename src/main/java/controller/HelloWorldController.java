package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import objects.Customer;
import respository.CustomerRepository;

@RestController
public class HelloWorldController {
	
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/")
	public ResponseEntity<String> findAll() {
		return new ResponseEntity<String>("Hello World", HttpStatus.OK);
	}
	
	
	@GetMapping("/stuff")
	public Customer getJsonObject() {
		Customer customer = new Customer("bob", "saget");
		
		return customer;
	}
	
	@PostMapping("/stuff")
	public ResponseEntity<Customer> writeCustomer(@RequestBody Customer customer) {
		System.out.println(customer + "got a customer");
		customer = customerRepository.save(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}
