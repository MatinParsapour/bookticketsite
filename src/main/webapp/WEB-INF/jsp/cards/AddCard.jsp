<%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/5/2021
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add card</title>
</head>
<body>
<div>
    <form action="cardValidation">
        <div align = "center">
            <label for="customerCardNumber">Card number : </label>
            <input id="customerCardNumber" type="text" name="customerCardNumber" onchange="this.value = parseInt(this.value);" placeholder="Card number" required>
        </div>
        <br>
        <br>
        <div style="margin-left: 570px;">
            <label for="customerCardCVV2">CVV2 : </label>
            <input id="customerCardCVV2" type="text" name="customerCardCVV2" onchange="this.value = parseInt(this.value);" placeholder="CVV2" required>
        </div>
        <br>
        <br>
        <div style="margin-left: 500px;">
            <label for="customerCardPassword">Second password : </label>
            <input id="customerCardPassword" type="password" name="customerCardPassword" onchange="this.value = parseInt(this.value);" placeholder="Second password" required>
        </div>
        <br>
        <br>
        <div style="margin-left: 515px;">
            <label for="customerCardExpirationDate">Expiration date : </label>
            <input id="customerCardExpirationDate" type="date" name="customerCardExpirationDate" placeholder="Expiration date" required>
        </div>
        <div align = "center" style="margin-top: .5cm;">
            <input style="width: 5cm;height: 1cm;" type="submit" placeholder="Submit" required>
        </div>
    </form>
</div>
</body>
</html>
