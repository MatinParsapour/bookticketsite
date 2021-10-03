package service;

import base.service.BaseService;
import domain.Customer;
import domain.Ticket;

public interface CustomerService extends BaseService<Customer, Long> {

    Customer checkCustomer(String username);

    Customer checkCustomerToEnter(String username, String password);
}
