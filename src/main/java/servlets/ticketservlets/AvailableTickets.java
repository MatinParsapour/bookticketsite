package servlets.ticketservlets;

import domain.Ticket;
import util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AvailableTickets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String origin  = req.getParameter("origin");
        String destination = req.getParameter("destination");
        String order = req.getParameter("order");
        String field = req.getParameter("field");
        List<Ticket> ticketList = ApplicationContext.getTicketServiceImpl().getTickets(origin,destination,field,order);
        HttpSession session = req.getSession(false);
        session.setAttribute("ticketList",ticketList);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/tickets/AvailableTickets.jsp");
        rd.forward(req,resp);
    }
}
