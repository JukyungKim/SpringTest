<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 결과 - ${method }</h1>
	
	성명 : ${name }<br />
	성별 : ${gender }<br />
	이메일 : ${email }<br /><br>
	<hr>
	성명 : ${vo.name }<br />
	성별 : ${vo.gender }<br />
	이메일 : ${vo.email }<br /><br>

<a href="join">회원 가입 화면으로 이동</a>
</body>
</html>