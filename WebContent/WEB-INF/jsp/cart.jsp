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
<title><fmt:message key="menu3" /></title>
</head>
<body>
<p><jsp:include page="setLanguage.jsp" /></p>

<h2><fmt:message key="company" /></h2>
<p><jsp:include page="menu.jsp" /></p>

<h2><fmt:message key="menu3" /></h2>
<table border="1" width="500">
<tr>
	<td><b><fmt:message key="name" /></b></td>
	<td><b><fmt:message key="des" /></b></td>
	<td><b><fmt:message key="price" /></b></td>
	<td><b><fmt:message key="quant" /></b></td>
	<td><b><fmt:message key="total" /></b></td>
</tr>
<c:forEach items="${items}" var="items">
<tr>
	<td width="30%"><c:out value="${items.vare.pName}"></c:out></td>
	<td width="35%"><kaffe:shorttext maxChars="20"><c:out value="${items.description}"></c:out></kaffe:shorttext></td>
	<td width="10%"><c:out value="${items.vare.priceInEuro}"></c:out></td>
	<td width="10%"><c:out value="${items.quantity}"></c:out></td>
	<td width="15%"><c:out value="${items.totalPrice}"></c:out></td>
</tr>

</c:forEach>
<tr>
	<td colspan="4" align="right"><b><fmt:message key="total_a" />:</b></td>
	<td><b><c:out value="${total_a}" /></b></td>
</tr>
</table>
</fmt:bundle>
<br>
<p>
	<kaffe:printCopyright since="2008"/>
</p>

</body>
</html>