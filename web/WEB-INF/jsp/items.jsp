<%-- 
    Document   : index
    Created on : 16 Jan, 2017, 12:10:24 AM
    Author     : Sakshi Agarwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <title>Lets Shop | Home</title>
    <style>
    * {
    box-sizing: border-box;
}
.row::after {
content: "";
    clear: both;
    display: table;
}
[class*="col-"] {
    float: left;
    padding: 15px;
}
.col-1 {width: 8.33%;}
.col-2 {width: 16.66%;}
.col-3 {width: 25%;}
.col-4 {width: 33.33%;}
.col-5 {width: 41.66%;}
.col-6 {width: 50%;}
.col-7 {width: 58.33%;}
.col-8 {width: 66.66%;}
.col-9 {width: 75%;}
.col-10 {width: 83.33%;}
.col-11 {width: 91.66%;}
.col-12 {width: 100%;}
 h1{
color:blue;
text-align:center;
margin-top:2%;

font-style:italic;
}
.button {
  display: inline-block;
  padding: 15px 25px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
form{
display:inline;
}
div{
background-color:#E4EDF1;
}
div.img {

    border: 1px solid #ccc;
    float: left;

    margin-left:2%;
    margin-right:2%;
}

div.img:hover {
    border: 1px solid #777;
}


p{
font-size:30px;
}
</style>
</head>
<body>
<h1 style="color:red;">LETS SHOP</h1>
<div class="row">
    <div class="col-6">
        <div class="img">
            <img src="${specsv.getSpecs_values()}" alt="image" width="400" height="500" />
        </div>
    </div>
    <div class="col-6" style="margin-top:5%;">
        <div>
            <c:forEach items="${specsd}" var="spec" >
                <p>${spec.getSpecification_name()} : ${spec.getSpecs_values()}</p>
            <br />
            </c:forEach>
        </div>

            <a href="homepage.htm">
            <button class="button">BOOKMARK THIS ITEM</button>
            </a>
            <a href="homepage.htm">
            <button class="button">ADD TO CART</button>
                </a>

    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</body>
</html>