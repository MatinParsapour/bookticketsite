package servlets.ticketservlets;

import domain.Ticket;
import util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TicketsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ticket> oneHourLastTickets = ApplicationContext.getTicketServiceImpl().getFinalMomentsTickets();
        if(oneHourLastTickets.size() != 0){
            for(Ticket ticket : oneHourLastTickets){
                double newPrice = ticket.getAmount() / 2;
                ticket.setAmount(newPrice);
                ticket.setIsPriceChanged(true);
                ApplicationContext.getTicketServiceImpl().createOrUpdate(ticket);
            }
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/tickets/Tickets.jsp");
        rd.forward(req, resp);
    }
}
