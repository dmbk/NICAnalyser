<%-- 
    Document   : NICInterpreter
    Created on : Sep 11, 2013, 3:25:32 PM
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
       <h1>Welcome to NIC calculator</h1>
        <h2>Sri lankan people's NIC calculator</h2>

        <form action="NICCalculator" method="POST">
            NIC Number <input type="text" name="nicNumber"/><br/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
