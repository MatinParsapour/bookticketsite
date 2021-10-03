package servlets.customerservlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerEnterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<form action=\"customerLogIn\">");
        out.println("<div style=\"text-align: center\">");
        out.println("<input type=\"submit\" value=\"Enter\" style=\"width: 200px; height: 50px\">");
        out.println("</div>");
        out.println("</form>");
        out.println("<form action=\"customerSignUp\">");
        out.println("<div style=\"text-align: center\">");
        out.println("<input type=\"submit\" value=\"Fill the form\" style=\"width: 200px; height: 50px\">");
        out.println("</div>");
        out.println("</form>");
    }
}
