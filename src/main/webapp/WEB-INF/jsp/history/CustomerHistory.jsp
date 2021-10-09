<%@ page import="domain.History" %>
<%@ page import="java.util.List" %>
<%@ page import="util.ApplicationContext" %><%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/5/2021
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<a href="customerMainMenu" style="float: right;">Back to menu</a>
<% List<History> histories = ApplicationContext.getHistoryServiceImpl().findCustomerHistory();
if(histories.size() == 0){
    out.println("You don't have any ticket yet");
}else{
    out.println("<table border=\"1px\" class=\"center\">\n" +
            "    <thead>\n" +
            "        <th>Origin</th>\n" +
            "        <th>Destination</th>\n" +
            "        <th>Departure date</th>\n" +
            "        <th>Return date</th>\n" +
            "        <th>Number of ticket</th>\n" +
            "        <th>Price</th>\n" +
            "        <th>Company name</th>\n" +
            "        <th>Buy</th>\n" +
            "        <th>Delete</th>\n" +
            "    </thead>\n" +
            "    <tbody>");
    for(History history : histories){
        out.println("        <tr>\n" +
                "            <td style=\"text-align: center;\">" + history.getTickets().getOrigin() + " </td>\n" +
                "            <td style=\"text-align: center;\">" + history.getTickets().getDestination() + " </td>\n" +
                "            <td style=\"text-align: center;\">" + history.getTickets().getDepartureDate() +"  </td>\n" +
                "            <td style=\"text-align: center;\">" + history.getTickets().getReturnDate() +" </td>\n" +
                "            <td style=\"text-align: center;\">" + history.getNumberOfTicket() +"  </td>\n" +
                "            <td style=\"text-align: center;\">" + history.getTickets().getAmount() +"  </td>\n" +
                "            <td style=\"text-align: center;\">" + history.getTickets().getCompany().getCompanyName() +"  </td>\n");
        if(history.getIsBought().equals(true)){
            out.println("            <td style=\"text-align: center;\"> - </td>\n" +
                    "            <td style=\"text-align: center;\"> - </td>\n");
        }else{
            out.println("            <td style=\"text-align: center;\">\n" +
                    "                <form action=\"buyTicket\">\n" +
                    "                    <input type=\"hidden\" name=\"ticket\" value=\"" + history.getTickets().getId() + "\">\n" +
                    "                    <input id=\"amount\" type=\"number\" name=\"numberOfPassengers\" placeholder=\"Number of ticket you want\">\n" +
                    "                    <br>\n" +
                    "                    <br>\n" +
                    "                    <input type=\"submit\" name=\"submit\" value=\"Buy ticket\">\n" +
                    "                </form>\n" +
                    "            </td>\n" +
                    "            <td style=\"text-align: center;\">\n" +
                    "                <form action=\"deleteTicket\">\n" +
                    "                    <input type=\"hidden\" name=\"ticket\" value=\"" + history.getTickets().getId() + "\">\n" +
                    "                    <input type=\"hidden\" name=\"history\" value=\"" + history.getId() + "\">\n" +
                    "                    <input type=\"submit\" name=\"submit\" value=\"Delete\">\n" +
                    "                </form>\n" +
                    "            </td>" +
                    " </tr>");
        }
    }
    out.println("</tbody>");
    out.println("</table>");
}
%>
</body>
</html>
