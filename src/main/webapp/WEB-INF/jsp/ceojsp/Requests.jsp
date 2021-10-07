<%@ page import="domain.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="util.ApplicationContext" %><%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/7/2021
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Requests</title>
</head>
<body>
<% List<Employee> employeeList = ApplicationContext.getEmployeeService().requests();
if(employeeList.size() == 0){
    out.println("There's no request for you");
}else{
    out.println("<table border=\"1px\">\n" +
            "    <thead>\n" +
            "        <tr>\n" +
            "            <th>Firstname</th>\n" +
            "            <th>Lastname</th>\n" +
            "            <th>Email</th>\n" +
            "            <th>Phone number</th>\n" +
            "            <th>National code</th>\n" +
            "            <th>Birth day</th>\n" +
            "            <th>Accept</th>\n" +
            "            <th>Reject</th>\n" +
            "        </tr>\n" +
            "    </thead>\n" +
            "    <tbody>");
    for(Employee employee : employeeList){
        out.println("<tr>\n" +
                "            <td style=\"text-align: center;\">" + employee.getFirstName() + "</td>\n" +
                "            <td style=\"text-align: center;\">" + employee.getLastName() + "</td>\n" +
                "            <td style=\"text-align: center;\">" + employee.getEmail() + "</td>\n" +
                "            <td style=\"text-align: center;\">" + employee.getPhoneNumber() + "</td>\n" +
                "            <td style=\"text-align: center;\">" + employee.getNationalCode() + "</td>\n" +
                "            <td style=\"text-align: center;\">" + employee.getBirthDate() + "</td>\n" +
                "            <td style=\"text-align: center;\">\n" +
                "                <form action=\"accept\">\n" +
                "                    <input type=\"hidden\" name=\"volunteerId\" value=\"" + employee.getId() + "\">\n" +
                "                    <input type=\"submit\" name=\"submit\" value=\"Accept\">\n" +
                "                </form>\n" +
                "            </td>\n" +
                "            <td style=\"text-align: center;\">\n" +
                "                <form action=\"reject\">\n" +
                "                    <input type=\"hidden\" name=\"volunteerId\" value=\"" + employee.getId() + "\">\n" +
                "                    <input type=\"submit\" name=\"submit\" value=\"Reject\">\n" +
                "                </form>\n" +
                "            </td>\n" +
                "        </tr>");
    }
}
out.println("</tbody>");
out.println("</table>");
%>
</body>
</html>
