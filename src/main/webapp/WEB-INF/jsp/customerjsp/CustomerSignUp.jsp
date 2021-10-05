<%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/3/2021
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<head>
    <title>Customer sign up</title>
    <h1 align="center">Welcome</h1>
    <h2 align="center">Fill the below form</h2>
</head>
<form action="customerFormValidation">
    <div align="center" style="margin-top: 1.5cm;">
        <label for="customerFirstName">Firstname : </label>
        <input id="customerFirstName" type="text" name="customerFirstName" placeholder="Enter your firstname" required>
    </div>
    <div align="center" style="margin-top: .5cm;">
        <label for="customerLastName">Lastname : </label>
        <input id="customerLastName" type="text" name="customerLastName" placeholder="Enter your lastname" required>
    </div>
    <div style="margin-top: .5cm; margin-left: 574px;">
        <label for="customerEmail">Email : </label>
        <input id="customerEmail" type="email" name="customerEmail" placeholder="example@example.com" required>
    </div>
    <div style="margin-top: .5cm;margin-left: 520px;">
        <label for="customerPhoneNumber">Phone number : </label>
        <input id="customerPhoneNumber" type="text" pattern="[9][0-9]{9}" name="customerPhoneNumber"
               onchange="this.value = parseInt(this.value);" placeholder=":9111111111" required>
    </div>
    <div style="margin-top: .5cm;margin-left: 519px;">
        <label for="customerNationalCode">National Code : </label>
        <input id="customerNationalCode" type="text" pattern="[0-9]{10}" name="customerNationalCode"
               onchange="this.value = parseInt(this.value);" placeholder=":1234567890" required>
    </div>
    <div align="center" style="margin-top: .5cm;">
        <label for="customerUserName">Username : </label>
        <input id="customerUserName" type="text" name="customerUserName" placeholder="Enter your username" required>
    </div>
    <div align="center" style="margin-top: .5cm;">
        <label for="customerPassword">Password : </label>
        <input id="customerPassword" type="password" pattern="^[0-9a-zA-Z]{8,16}$" name="customerPassword"
               placeholder="between 8 to 16 character" required>
    </div>
    <div style="margin-top: .5cm;margin-left: 555px;">
        <label for="customerBirthday">Birthday : </label>
        <input id="customerBirthday" type="date" name="customerBirthday" placeholder="Enter your birthday" required>
    </div>
    <div align="center" style="margin-top: .5cm;">
        <input style="width: 5cm;height: 1cm;" type="submit" placeholder="Submit" required>
    </div>
</form>
</body>
</html>
