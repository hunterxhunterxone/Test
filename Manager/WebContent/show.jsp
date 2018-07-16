<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="js/show.js"></script>
</head>
<body>
	<h1>Employee List Page</h1>
	<table border="1px" cellpadding="5px" cellspacing="0px">
		<tr>
			<td>ID</td>
			<td>LASTNAME</td>
			<td>EMAIL</td>
			<td>BIRTH</td>
			<td>CREATETIME</td>
			<td>DEPT</td>
			<td>DELETE</td>
			<td>EDIT</td>
		</tr>
		<c:forEach items="${sessionScope.list}" var="item">
			<tr>
				<td>${item.id }</td>
				<td>${item.lastName }</td>
				<td>${item.email }</td>
				<td>${item.birth }</td>
				<td>${item.createTime }</td>
				<td>${item.dept.deptName }</td>
				<td><a href="${pageContext.request.contextPath }/employee/deleteEmployee?id=${item.id }" id="delete">Delete</a></td>
				<td><a href="${pageContext.request.contextPath }/employee/findEmployee?id=${item.id }">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="../add.jsp">添加新员工</a>
</body>
</html>