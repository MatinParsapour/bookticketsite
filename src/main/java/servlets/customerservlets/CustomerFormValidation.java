package servlets.customerservlets;

import domain.Customer;
import lombok.SneakyThrows;
import util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerFormValidation extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String userName = req.getParameter("customerUserName");
        Customer existsCustomer = ApplicationContext.getCustomerService().checkCustomer(userName);
        if(existsCustomer != null){
            out.println("The username already exists choose another one");
        }else{
            HttpSession session = req.getSession(false);
            session.setAttribute("userName",userName);
            String firstName = req.getParameter("customerFirstName");
            String lastName = req.getParameter("customerLastName");
            String email = req.getParameter("customerEmail");
            long phoneNumber = Long.parseLong(req.getParameter("customerPhoneNumber"));
            long nationalCode = Long.parseLong(req.getParameter("customerNationalCode"));
            String password = req.getParameter("customerPassword");
            Date birthDate = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("customerBirthday"));
            Customer customer = new Customer(firstName,lastName,email,phoneNumber,nationalCode,birthDate,userName,password);
            ApplicationContext.getCustomerService().createOrUpdate(customer);
        }
    }
}
