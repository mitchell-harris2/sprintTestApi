package services;

import objects.Customer;
import objects.FullNameCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repositories.CustomerRepository;
import repositories.FullNameCustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FullNameCustomerRepository fullNameCustomerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getCustomerByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<FullNameCustomer> getCustomerFullNames() {
        return fullNameCustomerRepository.findAllCustomersWithFullName();
    }

    public List<Customer> getSortedCustomers() {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "lastName").ignoreCase();
        Sort sort = new Sort(order);
        return customerRepository.findAll(sort);
    }
}
