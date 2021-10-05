<%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/3/2021
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer log in</title>
    <h1 align = "center">Welcome</h1>
</head>
<body>
<form action="customerEnterValidation">
    <div align = "center" style="margin-top: 1.5cm;">
        <label for="customerUserName">Username : </label>
        <input id="customerUserName" type="text" name="customerUserName" placeholder="username" required>
    </div>
    <div align = "center" style="margin-top: .5cm;">
        <label for="customerPassword">Password : </label>
        <input id="customerPassword" type="password" name="customerPassword" placeholder="password" required>
    </div>
    <div align = "center" style="margin-top: .5cm;">
        <input style="width: 2.5cm;height: 1cm;" type="submit" placeholder="Submit" required>
    </div>
</form>
</body>
</html>
