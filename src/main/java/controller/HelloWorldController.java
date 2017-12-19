package controller;

import entities.FullNameCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import entities.Customer;
import services.CustomerService;

import java.util.List;

@RestController
public class HelloWorldController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public ResponseEntity<String> findAll() {
		return new ResponseEntity<String>("Hello World", HttpStatus.OK);
	}

	@GetMapping("/fullNames")
	public List<FullNameCustomer> findAllFullNames() {
		return customerService.getCustomerFullNames();
	}
	
	
	@GetMapping("/stuff")
	public Iterable<Customer> getJsonObject() {
		return customerService.getAllCustomers();
	}

	@GetMapping(path = "/stuff",params = {"firstName"})
	public Iterable<Customer> getJsonObject(@RequestParam("firstName") String firstName) {

		return customerService.getCustomerByFirstName(firstName);
	}
	
	@PostMapping("/stuff")
	public ResponseEntity<Customer> writeCustomer(@RequestBody Customer customer) {
		customer = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@GetMapping("/sortedCustomers")
	public List<Customer> getCustomersSortedByLastName() {
		return customerService.getSortedCustomers();
	}

	@GetMapping(path="/sortedCustomers", params = {"page"})
	public List<Customer> getCustomersSortedByLastName(@RequestParam("page") int pageNumber) {
		return customerService.getSortedCustomers(pageNumber, 5);
	}
}
