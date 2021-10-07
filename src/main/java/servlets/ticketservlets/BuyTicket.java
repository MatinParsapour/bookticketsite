package servlets.ticketservlets;

import domain.CreditCard;
import domain.Customer;
import domain.History;
import domain.Ticket;
import lombok.SneakyThrows;
import util.ApplicationContext;
import util.SecurityUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyTicket extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreditCard creditCard = ApplicationContext.getCreditCardService().findCustomerCardForBuyTicket(Long.parseLong(req.getParameter("customerCardNumber")));
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        if(creditCard == null){
            out.println("The card number is incorrect");
        }else{
            String expirationDate = req.getParameter("customerCardExpirationDate") + " 00:00:00.0";
            int cvv2 = Integer.parseInt(req.getParameter("customerCardCVV2"));
            long secondPassword = Long.parseLong(req.getParameter("customerCardPassword"));
            double result = (Double) session.getAttribute("result");
            if(creditCard.getCVV2() == cvv2 && String.valueOf(creditCard.getExpirationDate()).equals(expirationDate) && creditCard.getSecondPassword() == secondPassword){
                if(creditCard.getBalance() >= result){
                    Customer customer = SecurityUser.getCustomer();
                    double newBalance = creditCard.getBalance() - result;
                    creditCard.setBalance(newBalance);
                    Ticket ticket = (Ticket) session.getAttribute("ticket");
                    int numberOfTickets = (Integer) session.getAttribute("numberOfTickets");
                    History history = new History(customer,ticket,numberOfTickets,false,true);
                    customer.getTickets().add(ticket);
                    int newNumberOfPassenger = ticket.getNumberOfPassengers() - numberOfTickets;
                    ticket.setNumberOfPassengers(newNumberOfPassenger);
                    ApplicationContext.getTicketServiceImpl().createOrUpdate(ticket);
                    ApplicationContext.getHistoryServiceImpl().createOrUpdate(history);
                    ApplicationContext.getCustomerService().createOrUpdate(customer);
                    ApplicationContext.getCreditCardService().createOrUpdate(creditCard);
                    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/tickets/AvailableTickets.jsp");
                    rd.forward(req,resp);
                }else{
                    out.println("You don't have enough balance");
                }
            }else{
                out.println("The information is incorrect");
            }
        }
    }
}
