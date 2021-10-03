<%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/3/2021
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body style="background-image: url('https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia.istockphoto.com%2Fphotos%2Fceo-text-on-white-background-picture-id481914276&f=1&nofb=1'); background-size: cover">
<form action="ceoValidation">
  <div style="text-align: center">
    <input type="text" name='ceoCode' onchange="this.value = parseInt(this.value);" required>
    <br>
    <br>
    <input type="submit" value="Accept">
  </div>
</form>
</body>
</html>
