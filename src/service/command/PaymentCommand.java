/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.command;

import dao.BookingDAO;
import dao.RoomDAO;
import javax.servlet.http.HttpServletRequest;
import models.Booking;
import models.User;

/**
 *
 * @author Женя
 */
public class PaymentCommand implements BaseCommandI {

    @Override
    public String execute(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("CurrentUser");
        Booking book = (Booking) request.getSession().getAttribute("book");

        BookingDAO bookingDAO = new BookingDAO();
        RoomDAO roomDAO = null;

        //находим заказ по idUser и устанавливаем оплату в true
        bookingDAO.setPaymentTrue(book);
        //устанавливаем status комнаты в occupied(для исключения повторного заказа одной комнаты)
        roomDAO = new RoomDAO();
        roomDAO.setStatusRoomOcup(book);
        roomDAO.close();
        //получаем обновленный объект
        book = bookingDAO.getBookingByIdUser(currentUser.getId());
        bookingDAO.close();
        //следующая строка для обновления информации после нажатия кнопки PaymentCommand 
        request.getSession().removeAttribute("book");
        //если не удалять атрибут,то инфа на AnswerToOrder не изменится, но на самом деле все операции выполнятся правильно..
        // и результат станет виден лишь после повторной аутентификации
        request.getSession().setAttribute("book", book);
        return "/processJSP/userFrame/answerToBooking.jsp";
    }

}
