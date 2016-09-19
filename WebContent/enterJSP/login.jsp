<%-- 
    Document   : loginJSP
    Created on : 22.03.2016, 19:02:12
    Author     : fraian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Форма входа в систему</title>
</head>
<body>
	<br>
	<h1 align="center">Вход в систему</h1>
	<form action="/HotelTest/Controller" method="post">
		<table align="center">
			<tr>
				<td>Пользователь:</td>
				<td><input type="text" name="username" size="10"><br></td>
			</tr>
			<tr>
				<td>Пароль:</td>
				<td><input type="password" name="password" size="10"><br></td>
			</tr>
		</table>
		<p></p>
		<table align="center">
			<tr>
				<th>
					<p>
						<small> <input type="submit" name="login"
							value="Войти в систему">
						</small>
				<th>
					<p>
						<small> <input type="submit" name="registration"
							value="Зарегистрироваться">
						</small>
		</table>
		<p></p>
		<small> <small> P.S. При неверном вводе данных Вы
				автоматически отправляетесь на страницу регистрации !!! </small></small>
	</form>
	<br>
	<a
		href="http://localhost:8084/HotelTest/processJSP/adminFrame/AdminFrame.jsp">AdminFrame.jsp
	</a>
	<hr>
	<h3>${LogOut}</h3>
	<hr>
</body>
</html>
