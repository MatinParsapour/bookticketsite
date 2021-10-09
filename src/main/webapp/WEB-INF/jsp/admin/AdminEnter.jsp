<%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/9/2021
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Admin enter</title>
  <h1 align = "center">Welcome</h1>
</head>
<body>
<form action="adminEnterValidation">
  <div align = "center" style="margin-top: 1.5cm;">
    <label for="adminUserName">Username : </label>
    <input id="adminUserName" type="text" name="adminUserName" placeholder="username" required>
  </div>
  <div align = "center" style="margin-top: .5cm;">
    <label for="adminPassword">Password : </label>
    <input id="adminPassword" type="password" name="adminPassword" placeholder="password" required>
  </div>
  <div align = "center" style="margin-top: .5cm;">
    <input style="width: 2.5cm;height: 1cm;" type="submit" placeholder="Submit" required>
  </div>
</form>
</body>
</html>