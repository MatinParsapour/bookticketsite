package servlets.customerservlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerSignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String form = "<head>\n" +
                "    <h1 align = \"center\">Welcome</h1>\n" +
                "    <h2 align = \"center\">Fill the below form</h2>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action=\"customerFormValidation\">\n" +
                "        <div align = \"center\" style=\"margin-top: 1.5cm;\">\n" +
                "            <label for=\"customerFirstName\">Firstname : </label>\n" +
                "            <input id=\"customerFirstName\" type=\"text\" name=\"customerFirstName\" placeholder=\"Enter your firstname\" required>\n" +
                "        </div>\n" +
                "        <div align = \"center\" style=\"margin-top: .5cm;\">\n" +
                "            <label for=\"customerLastName\">Lastname : </label>\n" +
                "            <input id=\"customerLastName\" type=\"text\" name=\"customerLastName\" placeholder=\"Enter your lastname\" required>\n" +
                "        </div>\n" +
                "        <div style=\"margin-top: .5cm; margin-left: 574;\">\n" +
                "            <label for=\"customerEmail\">Email : </label>\n" +
                "            <input id=\"customerEmail\" type=\"email\" name=\"customerEmail\" placeholder=\"example@example.com\" required>\n" +
                "        </div>\n" +
                "        <div style=\"margin-top: .5cm;margin-left: 520;\">\n" +
                "            <label for=\"customerPhoneNumber\">Phone number : </label>\n" +
                "            <input id=\"customerPhoneNumber\" type=\"text\" pattern=\"[9][0-9]{9}\" name=\"customerPhoneNumber\" onchange=\"this.value = parseInt(this.value);\" placeholder=\":9111111111\" required>\n" +
                "        </div>\n" +
                "        <div style=\"margin-top: .5cm;margin-left: 519;\">\n" +
                "            <label for=\"customerNationalCode\">National Code : </label>\n" +
                "            <input id=\"customerNationalCode\" type=\"text\" pattern=\"[0-9]{10}\" name=\"customerNationalCode\" onchange=\"this.value = parseInt(this.value);\" placeholder=\":1234567890\" required>\n" +
                "        </div>\n" +
                "        <div align = \"center\" style=\"margin-top: .5cm;\">\n" +
                "            <label for=\"customerUserName\">Username : </label>\n" +
                "            <input id=\"customerUserName\" type=\"text\" name=\"customerUserName\" placeholder=\"Enter your username\" required>\n" +
                "        </div>\n" +
                "        <div align = \"center\" style=\"margin-top: .5cm;\">\n" +
                "            <label for=\"customerPassword\">Password : </label>\n" +
                "            <input id=\"customerPassword\" type=\"password\" pattern=\"^[:;,\\-@0-9a-zA-Zâéè'.\\s]{8,16}$\" name=\"customerPassword\" placeholder=\"between 8 to 16 character\" required>\n" +
                "        </div>\n" +
                "        <div style=\"margin-top: .5cm;margin-left: 555;\">\n" +
                "            <label for=\"customerBirthday\">Birthday : </label>\n" +
                "            <input id=\"customerBirthday\" type=\"date\" name=\"customerBirthday\" placeholder=\"Enter your birthday\" required>\n" +
                "        </div>\n" +
                "        <div align = \"center\" style=\"margin-top: .5cm;\">\n" +
                "            <input style=\"width: 5cm;height: 1cm;\" type=\"submit\" placeholder=\"Submit\" required>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</body>";
        PrintWriter out = resp.getWriter();
        out.println(form);
    }
}
