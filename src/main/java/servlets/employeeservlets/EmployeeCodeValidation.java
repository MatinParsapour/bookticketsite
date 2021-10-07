package servlets.employeeservlets;

import domain.Employee;
import util.ApplicationContext;
import util.SecurityUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeCodeValidation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        long employeeCode = Long.parseLong(req.getParameter("employeeCode"));
        Employee employee = ApplicationContext.getEmployeeService().getEmployeeByEmployeeCode(employeeCode);
        if(employee == null){
            out.println("The code is wrong");
        }else{
            SecurityUser.setEmployee(employee);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/employee/EmployeeMainMenu.jsp");
            rd.forward(req,resp);
        }
    }
}
