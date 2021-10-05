<%@ page import="domain.CreditCard" %>
<%@ page import="util.ApplicationContext" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/5/2021
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer credit cards</title>
</head>
<body>
<div style="width:fit-content;">
  <div style="width:300px; float:left; margin-left: 100px;">
    <form action="addCard">
      <input type="submit" name="addCard" id="addCard" value="Add card" style="width: 200px; height: 30px;">
    </form>
  </div>
  <% List<CreditCard> creditCardList = ApplicationContext.getCreditCardService().findCustomerCard();
  for(CreditCard creditCard : creditCardList){
    out.println(creditCard.getCardNumber());
    out.println(creditCard.getCVV2());
    out.println(creditCard.getBalance());
    out.println(creditCard.getExpirationDate());
    out.println(creditCard.getSecondPassword());
    out.println("<form action=\"increaseMoney\">\n" +
            "    <input type=\"hidden\" name=\"creditCard\" value=\"" + creditCard.getId() + "\">\n" +
            "    <input id=\"amount\" type=\"text\" name=\"amount\" onchange=\"this.value = parseInt(this.value);\" placeholder=\"Amount\">" +
            "    <input type=\"submit\" name=\"submit\" value=\"Increase money\">\n" +
            "</form>");
  }
  %>
</div>

</body>
</html>
