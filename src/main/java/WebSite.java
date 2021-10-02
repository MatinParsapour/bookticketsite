import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class WebSite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<form action=\"ceo\">");
        out.println("<div style=\"text-align: center\">");
        out.println("<input type=\"submit\" value=\"CEO\" style=\"width: 200px; height: 50px\">");
        out.println("</div>");
        out.println("</form>");
        out.println("<form action=\"employee\">");
        out.println("<div style=\"text-align: center\">");
        out.println("<input type=\"submit\" value=\"employee\" style=\"width: 200px; height: 50px\">");
        out.println("</div>");
        out.println("</form>");
        out.println("<form action=\"customer\">");
        out.println("<div style=\"text-align: center\">");
        out.println("<input type=\"submit\" value=\"customer\" style=\"width: 200px; height: 50px\">");
        out.println("</div>");
        out.println("</form>");
    }
}
