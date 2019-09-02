<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	label{
		width: 150px;
		background-color: yellow;
		display: inline-block;
	}
</style>
</head>
<body>
	<h1>직원입력</h1>
	<form action="empinsert" method="post">
	<label>직원번호:</label> <input type="number" name="employee_id" value="${emp.employee_id}"/><br/>
	<label>직원이름:</label> <input type="text" name="first_name" value="${emp.first_name}"/><br/>
	<label>직원성:</label> <input type="text" name="last_name" value="${emp.last_name}"/><br/>
	<label>이메일:</label> <input type="text" name="email" placeholder="id@mail.com" value="${emp.email}"/><br/>
	<label>전화번호:</label> <input type="tel" name="phone_number" placeholder="010-0000-0000" pattern="\d{3}-\d{4}-\d{4}" value="${emp.phone_number}"/><br/>
	<label>입사일:</label> <input type="date" name="hire_date" ><br/>
	<label>급여:</label> <input type="number" name="salary" value="${emp.salary}"/><br/>
	<label>커미션:</label> <input type="text" name="commission_pct" value="${emp.commission_pct}"/><br/>
	
	
	
	<label>부서이름:</label>:<select name = "department_id">
		<c:forEach items="${deptlist}" var="dept">
		<!-- 가져오는건 부서코드(실제 디비에 들어가는거) 보여지는건 부서 이름 -->
			<option value="${dept.department_id}">${dept.department_name }</option>
		</c:forEach>		
	</select><br/>
	
	<label>매니저:</label>:<select name = "manager_id">
		<c:forEach items="${managerlist}" var="m">
			<option >${m}</option>
		</c:forEach>		
	</select><br/>
	
	<label>직무:</label>:<select name = "job_id">
		<c:forEach items="${joblist}" var="j">
			<option >${j}</option>
		</c:forEach>		
	</select>
	
	
	
	<input type="submit" value="입력하기">
	</form>
</body>
</html>