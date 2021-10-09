<%@ page import="domain.Ticket" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Behsaz Rayaneh
  Date: 10/5/2021
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>available tickets</title>
</head>
<body>
<a href="customerMainMenu" style="float: right;">Back to menu</a>
<% List<Ticket> ticketList = (List) session.getAttribute("ticketList");
if(ticketList.size() == 0){
    out.println("There's no ticket for this root");
}else{
    out.println("<table border=\"1px\" class=\"center\">\n" +
            "    <thead>\n" +
            "        <th>Origin</th>\n" +
            "        <th>Destination</th>\n" +
            "        <th>Departure date</th>\n" +
            "        <th>Return date</th>\n" +
            "        <th>Number of passengers</th>\n" +
            "        <th>Price</th>\n" +
            "        <th>Company name</th>\n" +
            "        <th>book</th>\n" +
            "        <th>Buy</th>\n" +
            "    </thead>\n" +
            "    <tbody>");
    for(Ticket ticket : ticketList){
        out.println("        <tr>\n" +
                "            <td style=\"text-align: center;\">" + ticket.getOrigin() + "</td>\n" +
                "            <td style=\"text-align: center;\">" + ticket.getDestination() + "</td>\n" +
                "            <td style=\"text-align: center;\">" + ticket.getDepartureDate() + " </td>\n" +
                "            <td style=\"text-align: center;\">" + ticket.getReturnDate() + " </td>\n" +
                "            <td style=\"text-align: center;\">" + ticket.getNumberOfPassengers() + " </td>\n" +
                "            <td style=\"text-align: center;\">" + ticket.getAmount() + " </td>\n" +
                "            <td style=\"text-align: center;\">" + ticket.getCompany().getCompanyName() + " </td>\n" +
                "            <td style=\"text-align: center;\">\n" +
                "                <form action=\"bookTicket\">\n" +
                "                    <input type=\"hidden\" name=\"ticket\" value=\"" + ticket.getId() + "\">\n" +
                "                    <input id=\"amount\" type=\"number\" name=\"numberOfPassengers\" placeholder=\"Number of ticket you want\" required>\n" +
                "                    <br>\n" +
                "                    <br>\n" +
                "                    <input type=\"submit\" name=\"submit\" value=\"Book ticket\">\n" +
                "                </form>\n" +
                "            </td>\n" +
                "            <td style=\"text-align: center;\">\n" +
                "                <form action=\"buyTicket\">\n" +
                "                    <input type=\"hidden\" name=\"ticket\" value=\"" + ticket.getId() + "\">\n" +
                "                    <input type=\"number\" name=\"numberOfPassengers\" placeholder=\"Number of ticket you want\" required>\n" +
                "                    <br>\n" +
                "                    <br>\n" +
                "                    <input type=\"submit\" name=\"submit\" value=\"Buy ticket\">\n" +
                "                </form>\n" +
                "            </td>\n" +
                "        </tr>");
    }
    out.println("</tbody>");
    out.println("</table>");
}
%>
</body>
</html>
