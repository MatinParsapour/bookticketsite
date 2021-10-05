package servlets.creditcardservlets;

import domain.CreditCard;
import domain.Customer;
import lombok.SneakyThrows;
import util.ApplicationContext;
import util.SecurityUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CardValidationServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        long cardNumber = Long.parseLong(req.getParameter("customerCardNumber"));
        CreditCard creditCard = ApplicationContext.getCreditCardService().findDoplicateCardByCardNumber(cardNumber);
        if(creditCard == null){
            int cvv2 = Integer.parseInt(req.getParameter("customerCardCVV2"));
            Date expirationDate = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("customerCardExpirationDate"));
            long secondPassword = Long.parseLong(req.getParameter("customerCardPassword"));
            CreditCard newCreditCard = new CreditCard(cardNumber,cvv2,expirationDate,secondPassword);
            newCreditCard = ApplicationContext.getCreditCardService().createOrUpdate(newCreditCard);
            newCreditCard.setCustomer(SecurityUser.getCustomer());
            newCreditCard = ApplicationContext.getCreditCardService().createOrUpdate(newCreditCard);
            Customer customer = SecurityUser.getCustomer();
            List<CreditCard> creditCardList = customer.getCreditCards();
            creditCardList.add(newCreditCard);
            ApplicationContext.getCustomerService().createOrUpdate(customer);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/customerjsp/CustomerMainMenu.jsp");
            rd.forward(req,resp);
        }else{
            out.println("The card number is wrong");
        }
    }
}
