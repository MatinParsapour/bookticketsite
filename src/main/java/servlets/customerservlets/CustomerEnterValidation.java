package servlets.customerservlets;

import domain.Customer;
import util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerEnterValidation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("customerUserName");
        String password = req.getParameter("customerPassword");
        Customer customer = ApplicationContext.getCustomerService().checkCustomerToEnter(username,password);
        if(customer == null){
            out.println("The username or password is incorrect");
        }else{
            HttpSession session = req.getSession(false);
            session.setAttribute("customerLogInUserName",username);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/customerjsp/CustomerMainMenu.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
