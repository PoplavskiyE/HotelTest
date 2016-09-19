<%-- 
    Document   : answerToOrder
    Created on : 12.12.2015, 21:24:18
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AnswerToOrder</title>
    </head>
    <body>
        <hr/>
        <form action="/HotelTest/Controller" method="post">
            <table align="center">
                <tr>
                    <th><h3><b>
                                ${CurrentUser.login}.. Ваш заказ:</b></h3></th>
                </tr>
                <tr>
                    <th>Количество мест</th>
                    <th>Класс номера</th>
                    <th>Срок бронирования</th>
                </tr>
                <tr>
                    <td align="center"><c:out  value="${book.placeRoom}"/></td>
                    <td align="center"><c:out value="${book.classRoom}"/></td>
                    <td align="center"><c:out value="${book.timeBooking}"/></td>
                    <%-- <td><input type="submit" name="cancel" value="Cancel Order"/></td>--%>
                </tr>
            </table> 
            <hr>
            <table align="center" border="2">
                <tr>
                    <th>
                        <c:choose>
                            <c:when test="${book.coinsidence!=0 && book.payment==false}">
                                <h3>Заказ подтвержден ...Перейти к оплате 
                                    <input type="submit" name="payment" value="Payment"/></h3>
                                </c:when>
                                <c:when test="${book.coinsidence==0 && book.payment==false}">
                                <h3>Нет соответсвующих заказу номеров
                                    <input type="submit" name="newBooking" value="New Order"/></h3>
                                </c:when>
                                <c:when test="${book.coinsidence!=0 && book.payment==true}">
                                <h3>Вы проживаете в номере ${book.coinsidence}/
                                    Желаете съехать ?
                                    <input type="submit" name="moveAway" value="Съехать"/></h3>
                                </c:when>
                                <c:otherwise>
                                <h3>Запрос находится в обработке</h3>
                            </c:otherwise>
                        </c:choose>
                    </th>
                </tr>
            </table>
        </form>
        <hr>
        <form action="/HotelTest/Controller" method="POST">
            <input type="submit" name="logout" value="LogOut"/>
        </form>
    </body>
</html>
