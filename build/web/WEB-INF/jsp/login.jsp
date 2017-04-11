<%-- 
    Document   : login
    Created on : 13 Jan, 2017, 3:06:56 AM
    Author     : Sakshi Agarwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lets Shop!</title>
    </head>
    <style>
    h1{
color:blue;
text-align:center;
font-style:italic;
}
body{
background-color: #E4EDF1;
}
</style>

<body>
<h1 style="color:red;">LETS SHOP</h1>
<f:form action="Afterlogin.htm" commandName="login">
    <p align="middle">
    <td>username:</td>
    <td><input path="Username" type="text" name="username" /></td>
    </p>

    <p align="middle">
    <td>Password:</td>
    <td><input path="password" type="password" name="password" /></td>
    
    </p >
    <p align="middle"><input type="submit" value="Register as customer" /> </p>

			

    </f:form>
</body>


</html>