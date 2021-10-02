package service.impl;

import base.service.BaseServiceImpl;
import domain.Company;
import domain.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;
import util.SecurityUser;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }



}
