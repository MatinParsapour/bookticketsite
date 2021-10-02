package service.impl;

import base.service.BaseServiceImpl;
import domain.CEO;
import domain.Employee;
import repository.CEORepository;
import service.CEOService;
import util.ApplicationContext;
import util.SecurityUser;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CEOServiceImpl extends BaseServiceImpl<CEO, Long, CEORepository> implements CEOService {
    public CEOServiceImpl(CEORepository repository) {
        super(repository);
    }


}
