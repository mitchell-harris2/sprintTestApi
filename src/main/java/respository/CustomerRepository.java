package respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import objects.Customer;

public interface CustomerRepository extends Repository<Customer, Long> {
	void delete(Customer customer);
	List<Customer> findAll();
	Optional<Customer> findOne(Long id);
	Customer save(Customer customer);
}
