<%-- 
    Document   : newOrder
    Created on : 09.12.2015, 20:20:22
    Author     : fraian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Форма заказа номера</title>
    </head>
    <body>
        <form action="/HotelTest/Controller" method="post">
            <h1 align="center">Установите критерии заказа ... ${CurrentUser.login} ...</h1>
            <table align="center" >
                <tr>
                    <td><p>Количество мест:</td>
                    <td>
                        <select name="countPlaces">
                            <option selected disabled>Выберите </option>
                            <option value="1">1 (one place)</option>
                            <option value="2">2 (two places)</option>
                            <option value="3">3 (three places)</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><p>Класс аппартаментов:</td>
                    <td>
                        <select name="classRoom">
                            <option selected disabled>Выберите</option>
                            <option value="Lux">Lux</option>
                            <option value="Standart">Standart</option>
                            <option value="Econ">Econ</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><p>Время пребывания:</td>
                    <td><input type="text" name="timeBooking" size="12" value="0" /></td>
                    <td> дней</td>
                </tr>
                <tr>
                    <td><p><input type="submit" name="sendBook" value="Send Booking"/></td>
                    <td></td>
                    <td><input type="submit" name="logout" value="LogOut"/></td> 
                </tr>
            </table>
        </form>
    </body>
</html>
