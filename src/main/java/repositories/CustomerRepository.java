package repositories;

import entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findAll();

    List<Customer> findAll(Sort sort);

    Page<Customer> findAll(Pageable pageable);

}
