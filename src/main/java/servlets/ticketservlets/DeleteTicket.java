package servlets.ticketservlets;

import domain.History;
import domain.Ticket;
import util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long historyId = Long.parseLong(req.getParameter("history"));
        long ticketId = Long.parseLong(req.getParameter("ticket"));
        Ticket ticket = ApplicationContext.getTicketServiceImpl().findById(ticketId);
        int numberOfPassengers = ticket.getNumberOfPassengers();
        History history = ApplicationContext.getHistoryServiceImpl().findById(historyId);
        int numberOfTickets = history.getNumberOfTicket();
        int newNumberOfPassengers = numberOfPassengers + numberOfTickets;
        ticket.setNumberOfPassengers(newNumberOfPassengers);
        ApplicationContext.getTicketServiceImpl().createOrUpdate(ticket);
        ApplicationContext.getHistoryServiceImpl().delete(history);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/history/CustomerHistory.jsp");
        rd.forward(req,resp);
    }
}
