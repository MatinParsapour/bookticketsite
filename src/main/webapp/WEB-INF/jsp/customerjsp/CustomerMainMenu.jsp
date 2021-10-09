<%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/5/2021
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer main menu</title>
</head>
<body>
<a href="mainMenu" style="float: right;">Back to menu</a>
<div>
    <form action="history">
        <input type="submit" name="history" value="History" style="width: 200px;height: 30px;margin-left: 42.5%;">
    </form>
</div>
<div align = "center">
    <form action="allTickets">
        <input type="submit" name="allTickets" value="Book ticket" style="width: 200px;height: 30px;">
    </form>
</div>
<div align = "center">
    <form action="customerCards">
        <input type="submit" name="customerCards" value="Your cards" style="width: 200px;height: 30px;">
    </form>
</div>
</body>
</html>
