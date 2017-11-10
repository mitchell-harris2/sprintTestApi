package services;

import objects.Customer;
import objects.FullNameCustomer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repositories.CustomerRepository;
import repositories.FullNameCustomerRepository;

import java.util.ArrayList;
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

    public List<Customer> getSortedCustomers(int pageNumber, int size) {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "lastName").ignoreCase();
        Sort sort = new Sort(order);

        Page<Customer> page = customerRepository.findAll(new PageRequest(pageNumber,size, sort));

        return new ArrayList<Customer>(IteratorUtils.toList(page.iterator()));
    }
}
