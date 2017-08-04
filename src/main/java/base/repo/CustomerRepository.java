package base.repo;

/**
 * Created by kongxiangwen on 2017/8/4.
 */
import java.util.List;

import base.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
