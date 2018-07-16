<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="js/insert.js"></script>
</head>
<body>
	<c:choose>
      <c:when test="${sessionScope.employee==null}">
			<h1>Employee Input Page</h1>
			<form action="employee/insertEmployee" method="post">
				LastName:<input type="text" name="name"><p>
				Email:<input type="text" name="email"><p>
				Birth:<input type="text" name="birth"><p>
				Department:<select name="dept_id" id="dept_id">
							</select>
				<p>
				Student:<select name="student_id" id="student_id">
						</select>
				<p>
				<input type="submit" value="提交">
			</form>
	  </c:when>
      <c:otherwise>
      	<h1>Employee List Page</h1>
      	<form action="employee/updateEmployee?id=${sessionScope.employee.id }" method="post">
				LastName:<input type="text" name="name" value="${sessionScope.employee.lastName }"><p>
				Email:<input type="text" name="email" value="${sessionScope.employee.email}"><p>
				Birth:<input type="text" name="birth" value="${sessionScope.employee.birth}"><p>
				Department:<select name="dept_id" id="dept_id" value="${sessionScope.employee.dept.deptName}">
							</select>
				<p>
				<input type="submit" value="修改">
			</form>
      </c:otherwise>
      </c:choose>
	</body>
</html>