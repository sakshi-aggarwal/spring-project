<%-- 
    Document   : res
    Created on : 13 Jan, 2017, 4:03:40 AM
    Author     : Sakshi Agarwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
  
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
        response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma", "no-cache");
String userName = (String) session.getAttribute("user");
if (null == userName) {
    response.sendRedirect("login.htm"); 
}
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>lets shop!</h1>
   <p>successfully logged in</p>
   <h2>${username}</h2>
  
   <a href="logout.htm">logout</a>
   </body>
</html>
