<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 페이지입니다.</h1>
<form action="userRegisterAction.jsp" method="POST">
	아이디: <input type="text" name="mid" placeholder="username" value="ssar"><br>
	비밀번호: <input type="password" name="mpw" placeholder="password" value="1234"><br>
	이름: <input type="text" name="mname" placeholder="password" value="1234"><br>
	연락처: <input type="text" name="mphone" placeholder="password" value="1234"><br>
	이메일: <input type="text" name="memail" placeholder="password" value="1234"><br>
	닉네임: <input type="text" name="mnick" placeholder="password" value="1234"><br>
	<input type="submit">
</form>
</body>
</html>