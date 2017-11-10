package repositories;

import objects.Customer;
import objects.FullNameCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FullNameCustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT new objects.FullNameCustomer(c.firstName || ' ' || c.lastName) FROM Customer c")
    List<FullNameCustomer> findAllCustomersWithFullName();
}
