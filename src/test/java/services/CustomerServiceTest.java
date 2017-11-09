package services;

import objects.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repositories.CustomerRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void testGetAllCustomers() throws Exception {
        List<Customer> customers = Arrays.asList(new Customer("bob", "saget"));
        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.getAllCustomers();

        verify(customerRepository, times(1)).findAll();
    }

    @Test
    public void testGetCustomerByFirstName() throws Exception {
        List<Customer> customers = Arrays.asList(new Customer("bob", "saget"));
        String firstName = "bob";

        when(customerRepository.findByFirstName(firstName)).thenReturn(customers);

        assertEquals(customers, customerService.getCustomerByFirstName(firstName));

        verify(customerRepository, times(1)).findByFirstName(firstName);
    }

    @Test
    public void testSaveCustomer() throws Exception {
        Customer customer = new Customer("bob", "saget");
        when(customerRepository.save(customer)).thenReturn(customer);

        assertEquals(customer, customerService.saveCustomer(customer));

        verify(customerRepository, times(1)).save(customer);
    }
}