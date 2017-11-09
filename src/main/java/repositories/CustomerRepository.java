package repositories;

import org.springframework.data.repository.CrudRepository;

import objects.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findAll();

}
