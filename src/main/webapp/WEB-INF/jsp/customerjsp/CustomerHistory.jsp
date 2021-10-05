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
<% List<History> histories = ApplicationContext.getHistoryServiceImpl().findCustomerHistory();
if(histories.size() == 0){
    out.println("You don't have any ticket yet");
}else{
    for(History history : histories){
        out.println(history.getTickets().getCompany().getCompanyName());
        out.println(history.getTickets().getAmount());
        out.println(history.getTickets().getDepartureDate());
        out.println(history.getTickets().getReturnDate());
        out.println(history.getTickets().getOrigin());
        out.println(history.getTickets().getDestination());
        out.println(history.getNumberOfTicket());
        out.println(history.getIsBooked());
        out.println(history.getIsBought());
    }
}
%>
</body>
</html>
