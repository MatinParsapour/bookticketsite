package servlets.ticketservlets;

import domain.Customer;
import domain.History;
import domain.Ticket;
import util.ApplicationContext;
import util.SecurityUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BookTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long ticketId = Long.parseLong(req.getParameter("ticket"));
        int numberOfTicket = Integer.parseInt(req.getParameter("numberOfPassengers"));
        Ticket ticket = ApplicationContext.getTicketServiceImpl().findById(ticketId);
        int newNumberOfPassenger = ticket.getNumberOfPassengers() - numberOfTicket;
        ticket.setNumberOfPassengers(newNumberOfPassenger);
        Customer customer = SecurityUser.getCustomer();
        customer.getTickets().add(ticket);
        History history = ApplicationContext.getHistoryServiceImpl().findCustomerTicketHistory(ticketId);
        if(history == null){
            history = new History(customer,ticket,numberOfTicket,true,false);
        }else{
            int newNumberOfTickets = history.getNumberOfTicket() + numberOfTicket;
            history.setNumberOfTicket(newNumberOfTickets);
        }
        ApplicationContext.getCustomerService().createOrUpdate(customer);
        ApplicationContext.getTicketServiceImpl().createOrUpdate(ticket);
        ApplicationContext.getHistoryServiceImpl().createOrUpdate(history);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/tickets/AvailableTickets.jsp");
        rd.forward(req,resp);
    }
}
