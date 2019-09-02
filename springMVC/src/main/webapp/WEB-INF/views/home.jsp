<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title> Hello world! </title>
</head>
<body>
<h1>
	Hello world!  ${myname}  
</h1>


<select>
	<option>월요일</option>
	<option>금요일</option>
	<option>토요일</option>
	<option selected>일요일</option>
	
</select>



<P> The time on the server is ${serverTime}. </P>

</body>
</html>
