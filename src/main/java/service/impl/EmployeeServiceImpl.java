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

    public Employee getEmployeeByNationalCode(long nationalCode){
        return repository.findEmployeeByNationalCode(nationalCode);
    }

    @Override
    public Employee getEmployeeByEmployeeCode(long employeeCode) {
        return repository.findEmployeeByEmployeeCode(employeeCode);
    }

    public List<Employee> requests(){
        return repository.findRequestsForCEO();
    }

    public long generateEmployeeCode(){
        Random random = new Random();
        String employeeCodeString = "";
        while(true){
            employeeCodeString = "";
            for(int i = 0; i<10; i++){
                employeeCodeString += random.nextInt(9);
            }
            long employeeCode = Long.parseLong(employeeCodeString);
            Employee employee = repository.findEmployeeByEmployeeCode(employeeCode);
            if(employee == null){
                return employeeCode;
            }
        }
    }
}
