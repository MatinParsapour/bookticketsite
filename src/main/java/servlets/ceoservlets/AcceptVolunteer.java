package servlets.ceoservlets;

import domain.Employee;
import util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AcceptVolunteer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long employeeId = Long.parseLong(req.getParameter("volunteerId"));
        Employee employee = ApplicationContext.getEmployeeService().findById(employeeId);
        long employeeCode = ApplicationContext.getEmployeeService().generateEmployeeCode();
        employee.setIsEmployee(true);
        employee.setEmployeeCode(employeeCode);
        ApplicationContext.getEmployeeService().createOrUpdate(employee);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/ceojsp/Requests.jsp");
        rd.forward(req,resp);
    }
}
