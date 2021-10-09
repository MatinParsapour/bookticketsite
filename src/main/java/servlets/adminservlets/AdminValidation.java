package servlets.adminservlets;

import domain.Admin;
import util.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminValidation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("adminUserName");
        String password = req.getParameter("adminPassword");
        Admin admin = ApplicationContext.getAdminServiceImpl().getAdmin(username,password);
        if(admin == null){
            RequestDispatcher rd = req.getRequestDispatcher("");
            rd.forward(req,resp);
        }else{
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/admin/AdminMainMenu.jsp");
            rd.forward(req,resp);
        }
    }
}
