<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
	<h1>회사: ${company}</h1>
	<h1>부서: ${dept}</h1>
	<h1>이름: ${myname}</h1>
	<hr/>
	<form action="paramtest">
		ID : <input name="userid" type="number">
		NAME : <input name="username" type="text">
		<input type="submit" value="서버전송">
	</form>
	
	<form action="paramtest2">
		ID : <input name="userid" type="number">
		NAME : <input name="username" type="text">
		<input type="submit" value="서버전송2">
	</form>
	
	
</body>
</html>