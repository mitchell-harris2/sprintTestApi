package repositories;

import entities.Customer;
import entities.FullNameCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FullNameCustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT new entities.FullNameCustomer(c.firstName || ' ' || c.lastName) FROM Customer c")
    List<FullNameCustomer> findAllCustomersWithFullName();
}
