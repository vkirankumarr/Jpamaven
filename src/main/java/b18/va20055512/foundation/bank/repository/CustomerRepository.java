package b18.va20055512.foundation.bank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import b18.va20055512.foundation.bank.entities.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
