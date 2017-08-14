<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring-Social Connections</title>
</head>
<body>
	<c:forEach items="${providerIds}" var="provider">
		<h4>${provider}</h4>
		<c:if test="${not empty connectionMap[provider]}">
				You are connected to ${provider} as ${connectionMap[provider][0].displayName}
		</c:if>
		<c:if test="${empty connectionMap[provider]}">
			<div>
				You are not yet connected to ${provider}. Click
				<a href="<spring:url
						value="/connect/${provider}"/>">here</a>
				to connect to ${provider}.
			</div>
		</c:if>
	</c:forEach>
</body>
</html>