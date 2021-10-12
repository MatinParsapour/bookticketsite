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
<a href="customerMainMenu" style="float: right;">Back to menu</a>
<div style="width:fit-content;">
    <div style="width:300px; float:left; margin-left: 100px;">
        <form action="addCard">
            <input type="submit" name="addCard" id="addCard" value="Add card" style="width: 200px; height: 30px;">
        </form>
    </div>
    <br>
    <br>
    <br>
    <br>
    <style>
        .center {
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <table border="1px" class="center">
        <thead>
        <th>Card number</th>
        <th>CVV2</th>
        <th>Balance</th>
        <th>Expiration date</th>
        <th>Second password</th>
        <th>Increase money</th>
        <th>Change password</th>
        <th>Delete card</th>
        </thead>
        <tbody>
            <% List<CreditCard> creditCardList = ApplicationContext.getCreditCardService().findCustomerCard();
  for(CreditCard creditCard : creditCardList){
      out.println("<tr>");
      out.println("<td style=\"text-align: center;\">" + creditCard.getCardNumber() + "</td>");
      out.println("<td style=\"text-align: center;\">" + creditCard.getCVV2() + "</td>");
      out.println("<td style=\"text-align: center;\">" + creditCard.getBalance() + "</td>");
      out.println("<td style=\"text-align: center;\">" + creditCard.getExpirationDate() + "</td>");
      out.println("<td style=\"text-align: center;\">" + creditCard.getSecondPassword() + "</td>");
      out.println("<td style=\"text-align: center;\">\n" +
              "            <form action=\"increaseMoney\">\n" +
              "                <input type=\"hidden\" name=\"creditCard\" value=\"" + creditCard.getId() + "\">\n" +
              "                <input id=\"amount\" type=\"text\" name=\"amount\" onchange=\"this.value = parseInt(this.value);\" placeholder=\"Amount\">\n" +
              "                <br>\n" +
              "                <br>\n" +
              "                <input type=\"submit\" name=\"submit\" value=\"Increase money\">\n" +
              "            </form>\n" +
              "        </td>");
      out.println("<td style=\"text-align: center;\">\n" +
              "                    <form action=\"changePassword\">\n" +
              "                       <input type=\"hidden\" name=\"creditCard\" value=\"" + creditCard.getId() + "\">\n" +
              "                       <input type=\"text\" name=\"newPassword\" onchange=\"this.value = parseInt(this.value);\" placeholder=\"New password\">\n" +
              "                       <br>\n" +
              "                       <br>\n" +
              "                        <input type=\"submit\" name=\"submit\" value=\"New password\">\n" +
              "                   </form>\n" +
              "               </td>");
      out.println("</tr>");
  }
  %>
        </tbody>
    </table>
</div>

</body>
</html>
