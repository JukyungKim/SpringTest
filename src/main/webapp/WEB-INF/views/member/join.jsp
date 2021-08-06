<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 </h1>
	<form action="joinRequest" method="post">
		<table border='1'>
			<tr>
				<th>성명</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="gender" value="남" checked />남
					<input type="radio" name="gender" value="여" />여
				</td>
			</tr>
			<tr>
				<th>이메일22</th>
				<td><input type="text" name="email" /></td>
			</tr>					
		</table><br />
		<input type="submit" value="HttpServletRequest" onclick="action='joinRequestServlet'" />
		<input type="submit" value="@RequestParam" onclick="action='joinRequestParam'" />
		<input type="submit" value="데이터 객체" onclick="action='joinDataObject'" />
		<input type="submit" value="@PathVariable" onclick="go_submit(this.form)" />
	</form>
	<script type="text/javascript">
	function go_submit(f){
		if(f.name.value == '' || f.gender.value == '' || f.email.value){
			console.log("Not input");
		}
		f.action = 'joinPathVariable/' + f.name.value + '/' + f.gender.value + '/' + f.email.value;
		console.log("input");
	}
	</script>
</body>
</html>

