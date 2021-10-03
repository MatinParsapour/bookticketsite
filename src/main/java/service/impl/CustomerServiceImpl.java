package service.impl;

import base.service.BaseServiceImpl;
import domain.CreditCard;
import domain.Customer;
import domain.Ticket;
import repository.CustomerRepository;
import service.CustomerService;
import util.ApplicationContext;
import util.SecurityUser;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepository> implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }


    @Override
    public Customer checkCustomer(String username) {
        return repository.findCustomerByUserName(username);
    }
}
