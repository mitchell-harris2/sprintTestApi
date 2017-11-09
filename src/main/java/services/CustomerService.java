package services;

import objects.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getCustomerByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
