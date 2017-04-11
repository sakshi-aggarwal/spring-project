<%-- 
    Document   : endPage
    Created on : 19 Jan, 2017, 1:39:02 AM
    Author     : Sakshi Agarwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lets Shop</title>
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
    </head>
    <body>
        <h1>Thanks For Shopping ${sessionScope.user}!!</h1>
    </body>
</html>
