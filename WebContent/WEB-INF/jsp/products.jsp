<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="kaffe-libs" prefix="kaffe"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:bundle basename="site">
<link type="text/css" rel="stylesheet" href="<c:url value="/style.css" />" />
<title><fmt:message key="menu2" /></title>
</head>
<body>
<p><jsp:include page="setLanguage.jsp" /></p>

<h2><fmt:message key="company" /></h2>
<p><jsp:include page="menu.jsp" /></p>
<h2><fmt:message key="menu2" /></h2>

<c:forEach items="${des}" var="des">

	
<div class="row">
  	<div class="column side">
  		<b><c:out value="${des.pno.pName}"></c:out></b><br>
    	<img src="<c:url value="${des.pno.imageFile}"></c:url>" width="170" alt="<c:out value="${des.pno.pName}"></c:out>">
 	</div>
  	<div class="column middle">
  		<fmt:message key="name" />: <c:out value="${des.pno.pName}"></c:out><br>
  		<fmt:message key="price" />: <c:out value="${des.pno.priceInEuro}"></c:out><br>
  		<c:out value="${des.text}"></c:out><br>
  		<form action="cart" method="post">
  		<input type="hidden" name="choice" value="add">
  		<input type="hidden" name="id" value="<c:out value="${des.pno.pno}"/>">
		<input type="submit" value="<fmt:message key="cart" />" />
		</form>
  </div>
</div>		
<br>

</c:forEach>
</fmt:bundle>
<br>
<p>
	<kaffe:printCopyright since="2008"/>
</p>
</body>
</html>