package servlets.employeeservlets;

import domain.Employee;
import util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class VolunteerSituation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        long nationalCode = Long.parseLong(req.getParameter("volunteerNationalCode"));
        Employee employee = ApplicationContext.getEmployeeService().getEmployeeByNationalCode(nationalCode);
        if(employee == null){
            out.println("There's no application with this national code");
        }else{
            if(employee.getIsEmployee() == null){
                out.println("In progress");
            }else if(employee.getIsEmployee().equals(true)){
                out.println("You are an employee and this is your code : " + employee.getEmployeeCode());
            }else{
                out.println("You rejected");
            }
        }
    }
}
