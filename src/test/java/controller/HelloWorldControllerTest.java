package controller;

import objects.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import services.CustomerService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldControllerTest {

    @InjectMocks
    private HelloWorldController helloWorldController;

    @Mock
    private CustomerService customerService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetJsonObject_ReturnsOnlyMatchingFirstNames_WhenParamIsPresent() throws Exception {

        String firstName = "sam";
        ArrayList customers = new ArrayList();
        customers.add(new Customer("sam","Iam"));

        when(customerService.getCustomerByFirstName(firstName)).thenReturn(customers);

        assertEquals(customers,helloWorldController.getJsonObject(firstName));

        verify(customerService, times(1)).getCustomerByFirstName(firstName);
    }

    @Test
    public void testGetJsonObject_ReturnsAllCustomers_WhenNoParamIsPresent() throws Exception {

        ArrayList customers = new ArrayList();
        customers.add(new Customer("sam","Iam"));

        when(customerService.getAllCustomers()).thenReturn(customers);

        assertEquals(customers,helloWorldController.getJsonObject());

        verify(customerService, times(1)).getAllCustomers();
    }

    @Test
    public void testWriteCustomer_returnsSavedCustomer() throws Exception {

        Customer customer = new Customer("sam","Iam");
        Customer savedCustomer = new Customer("sam","Iam");
        savedCustomer.setId(1L);

        ResponseEntity<Customer> expectedResponse = new ResponseEntity<>(savedCustomer, HttpStatus.OK);

        when(customerService.saveCustomer(customer)).thenReturn(savedCustomer);

        assertEquals(expectedResponse,helloWorldController.writeCustomer(customer));

        verify(customerService, times(1)).saveCustomer(customer);
    }
}