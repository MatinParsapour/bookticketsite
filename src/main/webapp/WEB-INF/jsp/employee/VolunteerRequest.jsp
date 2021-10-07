<%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/7/2021
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your request</title>
</head>
<body>
<form action="volunteerNationalCodeValidation">
    <div style="text-align: center">
        <label for="volunteerNationalCode">Your national code</label>
        <input id="volunteerNationalCode" type="text" name='volunteerNationalCode' placeholder="Enter your national code" onchange="this.value = parseInt(this.value);" required>
        <br>
        <br>
        <input type="submit" value="Accept">
    </div>
</form>
</body>
</html>
