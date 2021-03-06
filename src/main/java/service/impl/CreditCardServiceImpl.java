package service.impl;

import base.service.BaseServiceImpl;
import domain.CreditCard;
import domain.History;
import repository.CreditCardRepository;
import service.CreditCardService;
import util.ApplicationContext;
import util.SecurityUser;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CreditCardServiceImpl extends BaseServiceImpl<CreditCard, Long, CreditCardRepository> implements CreditCardService {
    public CreditCardServiceImpl(CreditCardRepository repository) {
        super(repository);
    }

    public CreditCard findDoplicateCardByCardNumber(long cardNumber){
        return repository.findDouplicateCardByCardNumber(cardNumber);
    }

    public List<CreditCard> findCustomerCard() {
        return repository.findCustomerCreditCards();
    }

    public CreditCard findCustomerCardForBuyTicket(long customerCardNumber) {
        return repository.findCustomerCreditCardByCardNumber(customerCardNumber);
    }
}
