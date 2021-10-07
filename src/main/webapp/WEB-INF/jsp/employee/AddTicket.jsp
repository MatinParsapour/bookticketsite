<%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/7/2021
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add ticket</title>
</head>
<body>
<div>
    <form action="setTicket">
        <div style="text-align: center">
            <label for="origin">Origin : </label>
            <input type="text" name="origin" id="origin" placeholder="Origin">
        </div>
        <br>
        <br>
        <div style="margin-left: 530px;">
            <label for="destination">Destination : </label>
            <input type="text" name="destination" id="destination" placeholder="Destination">
        </div>
        <br>
        <br>
        <div style="margin-left: 460px">
            <label for="passengers">Number of passengers : </label>
            <input type="number" name="passengers" id="passengers" placeholder="Number of passengers">
        </div>
        <br>
        <br>
        <div style="margin-left: 505">
            <label for="departureDate">Departure date : </label>
            <input type="datetime-local" name="departureDate" id="departureDate" placeholder="Departure date">
        </div>
        <br>
        <br>
        <div style="margin-left: 522">
            <label for="returnDate">Return date : </label>
            <input type="datetime-local" name="returnDate" id="returnDate" placeholder="Return date">
        </div>
        <br>
        <br>
        <div style="margin-left: 560px">
            <label for="price">Price : </label>
            <input type="text" name="price" id="price" placeholder="price">
        </div>
        <div>
            <br>
            <br>
            <br>
            <input id="search" type="submit" name="search" value="Add ticket" style="margin-left: 600px;">
        </div>
    </form>
</div>
</body>
</html>
