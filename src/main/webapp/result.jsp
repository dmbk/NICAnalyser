<%-- 
    Document   : result
    Created on : Sep 11, 2013, 3:55:40 PM
    Author     : dulitha
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            
            int date = (Integer) request.getAttribute("date");
            int month = (Integer) request.getAttribute("month");
            int year = (Integer) request.getAttribute("year");
            String gender = (String) request.getAttribute("gender");
            boolean isVoter=(Boolean)request.getAttribute("isVoter");

            out.println("Year: 19" + year);
            out.println("Month: " + month);
            out.println("Date: "+date);
            out.println("Gender : " + gender);
            if(isVoter==true){
                out.println("Voter: YES" );
            }else{
                out.println("Voter: NO");
            }
        %>
    </body>
</html>
