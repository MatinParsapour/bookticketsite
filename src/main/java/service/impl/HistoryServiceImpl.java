package service.impl;

import base.service.BaseServiceImpl;
import domain.History;
import domain.Ticket;
import repository.HistoryRepository;
import service.HistoryService;
import util.ApplicationContext;
import util.SecurityUser;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HistoryServiceImpl extends BaseServiceImpl<History,Long, HistoryRepository> implements HistoryService {
    public HistoryServiceImpl(HistoryRepository repository) {
        super(repository);
    }


}
