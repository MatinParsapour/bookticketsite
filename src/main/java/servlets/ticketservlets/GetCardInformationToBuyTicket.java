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
import java.io.PrintWriter;

public class GetCardInformationToBuyTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        try {
            long HistoryIdToBuy = Long.parseLong(req.getParameter("historyIdToBuy"));
            session.setAttribute("historyIdToBuy",HistoryIdToBuy);
            setInformation(req, session);
        }catch (NumberFormatException exception){
            setInformation(req, session);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/tickets/GetCardInformation.jsp");
        rd.forward(req,resp);
    }

    private void setInformation(HttpServletRequest req, HttpSession session) {
        long ticketId = Long.parseLong(req.getParameter("ticket"));
        Ticket ticket = ApplicationContext.getTicketServiceImpl().findById(ticketId);
        int numberOfTickets = Integer.parseInt(req.getParameter("numberOfPassengers"));
        double price = ticket.getAmount();
        double result = (numberOfTickets * price);
        session.setAttribute("numberOfTickets",numberOfTickets);
        session.setAttribute("price",price);
        session.setAttribute("result",result);
        session.setAttribute("ticket",ticket);
    }
}
