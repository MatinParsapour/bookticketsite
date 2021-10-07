<%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/7/2021
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter Code</title>
</head>
<body>
<form action="employeeValidation">
    <div style="text-align: center">
        <label for="employeeCode">Enter your employee code : </label>
        <input id="employeeCode" type="text" name='employeeCode' onchange="this.value = parseInt(this.value);" required>
        <br>
        <br>
        <input type="submit" value="Accept">
    </div>
</form>
</body>
</html>
