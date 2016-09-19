<%-- 
    Document   : AdminFrame
    Created on : 08.12.2015, 14:35:13
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminFrame</title>
<style type="text/css">
.block1 {
	width: 500px;
	background: #ccc;
	padding: 5px;
	padding-right: 20px;
	border: solid 1px black;
	float: left;
}

.block2 {
	width: 500px;
	background: #ADD8E6;
	padding: 5px;
	border: solid 1px black;
	float: left;
	position: relative;
	top: 55px;
	left: -50px;
}

.block3 {
	width: 700px;
	background: #98FB98;
	padding: 5px;
	border: solid 1px black;
	float: left;
	position: relative;
	top: 100px;
	left: -50px;
}
</style>
</head>
<body>
	<form action="/HotelTest/Controller" method="POST">
		<input type="submit" name="logout" value="LogOut" />
		<div class="block1">
			<table border="2">
				<b>Список всех номеров в отеле: </b>
				<tr>
					<th>Номер (ID)</th>
					<th>Класс</th>
					<th>Мест</th>
					<th>Цена/(сут)</th>
					<th>Статус</th>
					<th>Срок заказа</th>
				</tr>
				<c:forEach var="room" items="${afForm.rooms}">
					<tr>
						<td align="center"><c:out value="${room.idRoom}" /></td>
						<td><small><small><c:out
										value="${room.classRoom}" /></small></small></td>
						<td align="center"><c:out value="${room.placeRoom}" /></td>
						<td align="center"><c:out value="${room.price}" /></td>
						<c:choose>
							<c:when test="${room.status=='occupied'}">
								<th><small><c:out value="${room.status}" /></small></th>
							</c:when>
							<c:when test="${room.status=='not occupied'}">
								<td><small><c:out value="${room.status}" /></small></td>
							</c:when>
						</c:choose>
						<%--вместо предыдущего (c:choose) <th><small><c:out value="${room.status}"/></small></th>--%>
						<td align="center"><c:out value="${room.timeOrder}" /></td>
						<%--<td><input type="radio" name="roomId" checked="true"></td>--%>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div class="block2">
			<table border=3 align="center">
				<b>Список всех зарегистрированных пользователей:</b>
				<tr>
					<th>id</th>
					<th>Логин</th>
					<th>Пароль</th>
					<th>Email</th>
					<th>Телефон</th>
					<th><input type="submit" name="deleteUser" value="Delete User" />
					</th>
				</tr>
				<c:forEach var="user" items="${afForm.users}">
					<tr>
						<td align="center"><c:out value="${user.id}" /></td>
						<td><c:out value="${user.login}" /></td>
						<td align="center"><c:out value="${user.password}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="+375 ${user.phone}" /></td>
						<td align="center"><input type="radio" name="userId"
							value="${user.id}" checked="true"></td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<div class="block3">
			<table border="1" align="center">
				<b>Список всех сделанных заказов:</b>
				<tr>
					<th>ID</th>
					<th>User Id</th>
					<th>Количество мест</th>
					<th>Класс номера</th>
					<th>Срок бронирования</th>
					<th>Совпадения</th>
					<th>Оплата</th>
					<th><input type="submit" name="deleteBooking"
						value="Delete Booking" /></th>
				</tr>
				<c:forEach var="booking" items="${afForm.bookings}">
					<tr>
						<td><c:out value="${booking.idBooking}" /></td>
						<td align="center"><c:out value="${booking.idUser}" /></td>
						<td align="center"><c:out value="${booking.placeRoom}" /></td>
						<td><c:out value="${booking.classRoom}" /></td>
						<td align="center"><c:out value="${booking.timeBooking}" /></td>
						<td align="center"><c:out value="${booking.coinsidence}" /></td>
						<td><c:out value="${booking.payment}" /></td>
						<td><input type="radio" name="idBooking"
							value="${booking.idBooking}" checked="true"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>