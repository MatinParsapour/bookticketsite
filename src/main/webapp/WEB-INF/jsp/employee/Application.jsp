<%@ page import="domain.Company" %>
<%@ page import="util.ApplicationContext" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/7/2021
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application</title>
    <h1 align="center">Welcome</h1>
    <h2 align="center">Fill the below form</h2>
</head>
<body>
<form action="volunteerFormValidation">
    <p>Choose the company you want to be employee</p>
    <% List<Company> companyList = ApplicationContext.getCompanyServiceImpl().findAll();
    for(Company company : companyList){
        out.println("        <div style=\"width: fit-content;\">\n" +
                "            <div style=\"float: left;\">\n" +
                "                <label for=\"companyName\">" + company.getCompanyName() + "</label>\n" +
                "                <input type=\"hidden\" name=\"companyId\" value=\"" + company.getId() + "\">\n" +
                "                <input id = \"companyName\" name = \"companyName\" type=\"radio\" value = \"" + company.getCompanyName() +"\">\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <br>\n" +
                "        <br>");
    }
    %>
    <div align="center" style="margin-top: 1.5cm;">
        <label for="employeeFirstName">Firstname : </label>
        <input id="employeeFirstName" type="text" name="employeeFirstName" placeholder="Enter your firstname"
               required>
    </div>
    <div align="center" style="margin-top: .5cm;">
        <label for="employeeLastName">Lastname : </label>
        <input id="employeeLastName" type="text" name="employeeLastName" placeholder="Enter your lastname" required>
    </div>
    <div style="margin-top: .5cm; margin-left: 564px;">
        <label for="employeeEmail">Email : </label>
        <input id="employeeEmail" type="email" name="employeeEmail" placeholder="example@example.com" required>
    </div>
    <div style="margin-top: .5cm;margin-left: 510px;">
        <label for="employeePhoneNumber">Phone number : </label>
        <input id="employeePhoneNumber" type="text" pattern="[9][0-9]{9}" name="employeePhoneNumber"
               onchange="this.value = parseInt(this.value);" placeholder=":9111111111" required>
    </div>
    <div style="margin-top: .5cm;margin-left: 509px;">
        <label for="employeeNationalCode">National Code : </label>
        <input id="employeeNationalCode" type="text" pattern="[0-9]{10}" name="employeeNationalCode"
               onchange="this.value = parseInt(this.value);" placeholder=":1234567890" required>
    </div>
    <div style="margin-top: .5cm;margin-left: 545px;">
        <label for="employeeBirthday">Birthday : </label>
        <input id="employeeBirthday" type="date" name="employeeBirthday" placeholder="Enter your birthday" required>
    </div>
    <div align="center" style="margin-top: .5cm;">
        <input style="width: 5cm;height: 1cm;" type="submit" placeholder="Submit" required>
    </div>
</form>
</body>
</html>
