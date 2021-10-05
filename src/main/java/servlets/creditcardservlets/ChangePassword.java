package servlets.creditcardservlets;

import domain.CreditCard;
import util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long cardId = Long.parseLong(req.getParameter("creditCard"));
        CreditCard creditCard = ApplicationContext.getCreditCardService().findById(cardId);
        long newPassword = Long.parseLong(req.getParameter("newPassword"));
        creditCard.setSecondPassword(newPassword);
        ApplicationContext.getCreditCardService().createOrUpdate(creditCard);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/cards/CustomerCreditCards.jsp");
        rd.forward(req,resp);
    }
}
