package service.impl;

import base.service.BaseServiceImpl;
import domain.Company;
import domain.History;
import domain.Ticket;
import repository.TicketRepository;
import service.TicketService;
import util.ApplicationContext;
import util.SecurityUser;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TicketServiceImpl extends BaseServiceImpl<Ticket, Long, TicketRepository> implements TicketService {
    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }


}
