package servlets.ceoservlets;

import util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CEOEnterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<body style=\"background-image: url('https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia.istockphoto.com%2Fphotos%2Fceo-text-on-white-background-picture-id481914276&f=1&nofb=1'); background-size: cover\">");
        out.println("<form action=\"ceoValidation\">");
        out.println("<div style=\"text-align: center\">");
        out.println("<input type=\"text\" name='ceoCode' onchange=\"this.value = parseInt(this.value);\" required>");
        out.println("<br>");
        out.println("<br>");
        out.println("<input type=\"submit\" value=\"Accept\">");
        out.println("</div>");
        out.println("</form>");
        out.println("</body>");
    }
}
