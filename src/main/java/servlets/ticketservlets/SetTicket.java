package servlets.ticketservlets;

import domain.Company;
import domain.Ticket;
import lombok.SneakyThrows;
import util.ApplicationContext;
import util.SecurityUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetTicket extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String origin = req.getParameter("origin");
        Company company = SecurityUser.getEmployee().getCompany();
        String destination = req.getParameter("destination");
        int numberOfPassengers =Integer.parseInt(req.getParameter("passengers"));
        Date departureDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(req.getParameter("departureDate"));
        Date returnDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(req.getParameter("returnDate"));
        double price = Double.parseDouble(req.getParameter("price"));
        Ticket ticket = new Ticket(origin,destination,departureDate,returnDate,numberOfPassengers,price);
        ticket.setCompany(company);
        ApplicationContext.getTicketServiceImpl().createOrUpdate(ticket);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/employee/EmployeeMainMenu.jsp");
        rd.forward(req,resp);
    }
}
