package servlets.ceoservlets;

import domain.CEO;
import util.ApplicationContext;
import util.SecurityUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CEOCodeValidation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        String ceoCode = req.getParameter("ceoCode");
        session.setAttribute("ceoCode",ceoCode);
        PrintWriter out = resp.getWriter();
        long ceoCodeLong = Long.parseLong((String) session.getAttribute("ceoCode"));
        CEO ceo = ApplicationContext.getCEOService().checkCEO(ceoCodeLong);
        if(ceo != null){
            SecurityUser.setCeo(ceo);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/ceojsp/MainMenu.jsp");
            rd.forward(req,resp);
        }else{
            out.println("The code is wrong");
        }
    }
}
