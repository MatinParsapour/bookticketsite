<%@ page import="domain.Ticket" %>
<%@ page import="util.ApplicationContext" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/5/2021
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tickets</title>
</head>
<body>
<div style="width: fit-content;">
    <form action="availableTickets">
        <div style="width: 300px;float: left;margin-left: 150px;">
            <label for="origin">Origin : </label>
            <input id="origin" type="text" name="origin" placeholder="Origin" required>
        </div>
        <div style="width: 300px;float: left;">
            <label for="destination">Destination : </label>
            <input id="destination" type="text" name="destination" placeholder="Destination" required>
        </div>
        <div style="width: 200px;float: left;">
            <select name="field">
                <option value="price">Price</option>
                <option value="origin">Origin</option>
                <option value="destination">Destination</option>
                <option value="companyName">Company name</option>
            </select>
        </div>
        <div style="width: 200px;float: left;">
            <select name="order">
                <option value="ascending">Ascending</option>
                <option value="descending">Descending</option>
            </select>
        </div>
        <div>
            <br>
            <br>
            <input id="search" type="submit" name="search" value="Search for tickets" style="margin-left: 550px;">
        </div>
    </form>
</div>
</body>
</html>
