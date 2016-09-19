<%-- 
    Document   : registration
    Created on : 19.03.2016, 16:07:08
    Author     : fraian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Форма регистрации пользователей</title>
</head>
<body>
	<h1 align="center">Регистрация пользователя</h1>
	<form action="/HotelTest/Controller" method="post">
		<table align="center">
			<tr>
				<td>Пользователь:</td>
				<td><input type="text" name="username" size="10"
					value=${username}><br></td>
				<td>${incorrectUsername}</td>
			</tr>
			<tr>
				<td>Пароль:</td>
				<td><input type="password" name="password" size="10"
					value=${password}><br></td>
				<td>${incorrectPassword}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value=${email}><br></td>
				<td>${incorrectEmail}</td>
			</tr>
			<tr>
				<td>Телефон: +375</td>
				<td><input type="text" name="phone" value=${phone}><br></td>
				<td>${incorrectPhone}</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td></td>
				<td>${commonError}</td>
			</tr>
		</table>
		<p></p>
		<table align="center">
			<tr>
				<th><small> <input type="submit" name="save"
						value="Сохранить">
				</small> <%-- <th><small>
                                 <input type="submit" name="cancel" value="Выйти" >
                             </small>--%>
			</tr>
			<tr>
				<th><a href="/HotelTest/index.html">На главную</a></th>
			</tr>
		</table>
	</form>
</body>
</html>
