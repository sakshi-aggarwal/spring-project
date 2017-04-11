<%-- 
    Document   : authorisedHome
    Created on : 17 Jan, 2017, 8:47:59 PM
    Author     : Sakshi Agarwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
        response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma", "no-cache");
String userName = (String) session.getAttribute("user");
if (null == userName) {
    response.sendRedirect("login.htm"); 
}
       --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <title>Lets Shop!</title>
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
<h1 style="color:red;">LETS SHOP</h1>
<h3>Hi ${sessionScope.user} !</h3>
<div class="row">
<div class="col-sm-2" style="height: 100%;">
<div class="btn-group-vertical">
  <h4>Categories</h4>
  <div class="btn-group">
    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
     Clothes <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu">
      <li><a href="prods/1.htm">Jeans</a></li>
      <li><a href="prods/2.htm">Tops</a></li>
	  <li><a href="prods/3.htm">Jackets</a></li>
	  <li><a href="prods/4.htm">Shirts</a></li>
	  <li><a href="prods/5.htm">Skirts</a></li>
    </ul>
  </div>
  <div class="btn-group">
    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
     Electronics <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu">
      <li><a href="prods/6.htm">Phones</a></li>
      <li><a href="prods/7.htm">Headphones</a></li>
	  <li><a href="prods/8.htm">T.V</a></li>
	  <li><a href="prods/9.htm">Speakers</a></li>
	  <li><a href="prods/10.htm">Power Banks</a></li>
    </ul>
  </div>
  <div class="btn-group">
    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
     Furniture <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu">
      <li><a href="prods/11.htm">Sofas</a></li>
      <li><a href="prods/12.htm">Chairs</a></li>
	  <li><a href="prods/13.htm">Tables</a></li>
    </ul>
  </div>
  <div class="btn-group">
    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
     Footwears <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu">
      <li><a href="prods/14.htm">Sandals</a></li>
      <li><a href="prods/15.htm">Shoes</a></li>
	  <li><a href="prods/16.htm">Bellies</a></li>
    </ul>
  </div>
  <div class="btn-group">
    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
     Fashion Accessories <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu">
      <li><a href="prods/17.htm">Necklace</a></li>
      <li><a href="prods/18.htm">Braclets</a></li>
	  <li><a href="prods/19.htm">Earrings</a></li>
    </ul>
  </div>
  <div class="btn-group">
    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
     Home Appliances <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu">
      <li><a href="prods/20.htm">Fans</a></li>
      <li><a href="prods/21.htm">Coolers</a></li>
	  <li><a href="prods/22.htm">A.C</a></li>
    </ul>
  </div>
  <div class="btn-group">
    <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
     Kitchen Appliances <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu">
      <li><a href="prods/23.htm">Cookers</a></li>
      <li><a href="prods/24.htm">Stoves</a></li>
	  <li><a href="prods/25.htm">Juice Makers</a></li>
    </ul>
  </div>
  </div>
  </div>
  <div class="col-sm-1">
  </div>
  <div class="col-sm-3"> 
     <img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSd2Zto_eYK8zJLgDB98RmL45A2TeMmi1x8Y8RlgNBHTDrohicKlw" width="304" height="236"/>
    </div>
	<div class="col-sm-3"> 
     <img src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQ37ZZy2COazojrBaGB_W9c7GWS8V90U8d3XHXatvCMuHMQB-_YS4Jh1E9-" width="304" height="236"/>
    </div>
	<div class="col-sm-1">
	</div>
	<div class="col-sm-1">
      <f:form  action="showBookmarks.htm"  style="color:blue">
    <input type="submit" href="showBookmarks.htm" value="Bookmarks" />
      </f:form>
    </div>
   <div class="col-sm-1">
       <f:form  action="showCartItems.htm"  style="color:blue">
       <input type="submit" href="showCartItems.htm" value="Cart-Items" />
       </f:form>
       <br />
       <f:form  action="logout.htm"  style="color:blue">
       <input type="submit" href="login.htm" value="Logout" />
       </f:form>
  </div>
   </div><br />
  <div class="container">
  <div class="row">
    <div class="col-sm-4">
     <img src="http://assets.myntassets.com/h_240,q_95,w_180/v1/images/style/properties/Belle-Fille-Royal-Blue-Hooded-Sweatshirt_e6e8e910aa75c448f8b16c1f1d310197_images_mini.jpg" class="img-thumbnail" width="304" height="236"/>
    </div>
    <div class="col-sm-4">
     <img src="http://www.shop.net/images/winterwear.jpg" class="img-thumbnail" width="304" height="236"/>
    </div>
	<div class="col-sm-4">
     <img src="http://3.imimg.com/data3/AV/HL/MY-2800802/winter-wear-250x250.jpg" class="img-thumbnail" width="304" height="236"/>
    </div>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>