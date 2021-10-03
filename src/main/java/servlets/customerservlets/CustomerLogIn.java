package servlets.customerservlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerLogIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String form = "<head>\n" +
                "    <h1 align = \"center\">Welcome</h1>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action=\"customerEnterValidation\">\n" +
                "        <div align = \"center\" style=\"margin-top: 1.5cm;\">\n" +
                "            <label for=\"customerUserName\">Username : </label>\n" +
                "            <input id=\"customerUserName\" type=\"text\" name=\"customerUserName\" placeholder=\"username\" required>\n" +
                "        </div>\n" +
                "        <div align = \"center\" style=\"margin-top: .5cm;\">\n" +
                "            <label for=\"customerPassword\">Password : </label>\n" +
                "            <input id=\"customerPassword\" type=\"password\" name=\"customerPassword\" placeholder=\"password\" required>\n" +
                "        </div>\n" +
                "        </div>\n" +
                "        <div align = \"center\" style=\"margin-top: .5cm;\">\n" +
                "            <input style=\"width: 2.5cm;height: 1cm;\" type=\"submit\" placeholder=\"Submit\" required>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</body>";
        out.println(form);
    }
}
