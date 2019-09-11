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
<title><fmt:message key="menu1" /></title>
</head>
<body>
<p><jsp:include page="setLanguage.jsp" /></p>

<h2><fmt:message key="company" /></h2>
<p><jsp:include page="menu.jsp" /></p>

	<img src="<c:url value="images/cup.jpg" />" alt="cup"/>
</fmt:bundle>
<br>
<p>
	<kaffe:printCopyright since="2008"/>
</p>
<br>

</body>
</html>