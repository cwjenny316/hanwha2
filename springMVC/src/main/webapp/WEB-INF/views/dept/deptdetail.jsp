<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서의 상세보기</h1>
<form action="deptdetail" method="post">
부서번호 :<input type="number" name="department_id" value= "${dept.department_id}"> <br/>
부서이름 :<input type="text" name="department_name" value= "${dept.department_name}"> <br/>
<img alt="이미지" src="${path}/resources/${dept.fileName}" width="200" height="200">

<img alt="이미지" src="${path}/resources/photo1.jpg"> 
<a href="deptdownload?folder=resources&file=${dept.fileName}">이미지 다운받기</a>
<input type="submit" value="수정하기">

</form>
</body>
</html>