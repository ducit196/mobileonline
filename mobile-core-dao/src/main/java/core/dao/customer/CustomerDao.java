package core.dao.customer;

import core.dto.model.customer.Customer;

public interface CustomerDao {

    void add(Customer customer);
    void update(Customer customer);

    Customer getById(int customerId);

    Customer getByAccountId(int accountId);

}
