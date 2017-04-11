<%-- 
    Document   : bookmark
    Created on : 18 Jan, 2017, 3:13:19 AM
    Author     : Sakshi Agarwal
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Lets Shop</title>
</head>
<body>
<c:redirect url="/authorisedItems.htm" >
 <c:param name="pr_no" value="${pn}"/> 
</c:redirect>

</body>
</html




