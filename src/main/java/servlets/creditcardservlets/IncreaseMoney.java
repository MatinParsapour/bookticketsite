package servlets.creditcardservlets;

import domain.CreditCard;
import util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IncreaseMoney extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long creditCardId = Long.parseLong(req.getParameter("creditCard"));
        CreditCard creditCard = ApplicationContext.getCreditCardService().findById(creditCardId);
        double currentBalance = creditCard.getBalance();
        double amount = Double.parseDouble(req.getParameter("amount"));
        double newBalance = currentBalance + amount;
        creditCard.setBalance(newBalance);
        ApplicationContext.getCreditCardService().createOrUpdate(creditCard);
    }
}
