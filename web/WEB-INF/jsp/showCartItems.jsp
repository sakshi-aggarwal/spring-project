<%-- 
    Document   : showCartItems
    Created on : 19 Jan, 2017, 12:55:09 AM
    Author     : Sakshi Agarwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

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
body{
background-color:#E4EDF1;
}
div.img {

    border: 1px solid #ccc;
    float: left;
    width: 180px;
    margin-left:2%;
    margin-right:2%;
}

div.img:hover {
    border: 1px solid #777;
}

div.img img {
    width: 100%;

}

div.desc {
    padding: 15px;
    text-align: center;
}
</style>
</head>
<body>
<h1 style="color:red;">LETS SHOP</h1>
<h3>${sessionScope.user}</h3><br />
<div class="row">
    <div class="col-10" id="a">

        <div class="col s12 l4">
            <c:forEach items="${discr}" var="disc" >
<div class="img">
   
     <a href="<c:url value="/authorisedItems.htm">
            <c:param name='pr_no' value="${disc.getPr_no()}"/>
         </c:url>">

                        <img src="${disc.getUrl()}" alt="in process" width="400" height="250" >
</a>
                        <div class="desc"><p>${disc.getBrand()}</p><p> </p><p>${disc.getColour()}</p></div>
                         <f:form  action="removeCartItem.htm?pr_no=${disc.getPr_no()}"  style="color:blue">
       <input type="submit" class="desc" value="Remove From Cart" />
       </f:form>
</div>
                     </c:forEach>
        </div>
    </div>
    

   <div class="col-2">
       <f:form  action="showBookmarks.htm"  style="color:blue">
       <input type="submit" href="showBookmarks.htm" value="Bookmarks" />
       </f:form>
       <br />
       <f:form  action="endPage.htm"  style="color:blue">
       <input type="submit" href="endPage.htm" value="Check-Out" />
       </f:form>
        <br />
       <f:form  action="logout.htm"  style="color:blue">
       <input type="submit" href="login.htm" value="Logout" />
       </f:form>  
  </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>