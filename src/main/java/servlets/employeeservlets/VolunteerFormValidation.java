package servlets.employeeservlets;

import domain.Company;
import domain.Employee;
import lombok.SneakyThrows;
import util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VolunteerFormValidation extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        long nationalCode = Long.parseLong(req.getParameter("employeeNationalCode"));
        Employee existEmployee = ApplicationContext.getEmployeeService().getEmployeeByNationalCode(nationalCode);
        if(existEmployee == null){
            long companyId = Long.parseLong(req.getParameter("companyId"));
            Company company = ApplicationContext.getCompanyServiceImpl().findById(companyId);
            String firstName = req.getParameter("employeeFirstName");
            String lastName = req.getParameter("employeeLastName");
            String email = req.getParameter("employeeEmail");
            long phoneNumber = Long.parseLong(req.getParameter("employeePhoneNumber"));
            Date birthDay = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("employeeBirthday"));
            Employee employee = new Employee();
            employee.setIsEmployee(null);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setPhoneNumber(phoneNumber);
            employee.setBirthDate(birthDay);
            employee.setNationalCode(nationalCode);
            employee.setCompany(company);
            ApplicationContext.getEmployeeService().createOrUpdate(employee);
            RequestDispatcher rd = req.getRequestDispatcher("");
            rd.forward(req,resp);
        }else {
            out.println("The national code is wrong");
        }
    }
}
