<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<form:form action="${pageContext.request.contextPath}/user" method="POST" modelAttribute="user">
			<c:if test="${user.id == null }">
				账户：<form:input path="name" />
				<%-- <form:errors path="name"></form:errors> --%>
				<br>
				<br>
				 密码：<form:password path="pd" />
				<%-- <form:errors path="pd"></form:errors> --%>
			</c:if>

			<c:if test="${user.id != null }">
				<form:hidden path="id" />
				<input type="hidden" name="_method" value="PUT" />
			</c:if>
			账户：<form:input path="name" />
			<%-- <form:errors path="name"></form:errors> --%>
			<br>
			<br>
			 密码：<form:password path="pd"/>
			<%-- <form:errors path="pd"></form:errors> --%>
			<br>
			<br>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>