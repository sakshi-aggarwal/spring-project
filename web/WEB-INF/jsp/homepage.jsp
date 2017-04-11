<%-- 
    Document   : homepage
    Created on : 14 Jan, 2017, 7:07:34 PM
    Author     : Sakshi Agarwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Lets Shop!</title>
</head><style>
h1{
color:blue;
text-align:center;
font-style:italic;
}
body{
background-color: #E4EDF1;
}
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    align:middle;
}
</style>

<body >

<h1 style="color:red;">LETS SHOP</h1>
<f:form  action="login.htm"  style="color:blue">
    <input type="submit" href="home.htm" value="Sign-Up" />
</f:form>

<f:form  action="login.htm"  style="color:blue">
    <input type="submit" href="login.htm" value="Sign-In" />
</f:form>

</body>
</html>