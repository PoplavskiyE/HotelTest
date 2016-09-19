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
public class SendBookCommand implements BaseCommandI {

    @Override
    public String execute(HttpServletRequest request) {

        BookingDAO bookingDAO = new BookingDAO();
        RoomDAO roomDAO = new RoomDAO();

        Integer loginId = ((User) request.getSession().getAttribute("CurrentUser")).getId();
        String countPlace = request.getParameter("countPlaces");
        String classRoom = request.getParameter("classRoom");
        String timeBooking = request.getParameter("timeBooking");

        //находит совпадения заказа в таблице комнат
        Integer tempRoom = roomDAO.findCoinsidence(classRoom, countPlace);
        roomDAO.close();
//Constructor without setId
        Booking newBooking = new Booking(loginId, countPlace, classRoom,
                timeBooking, tempRoom, Boolean.FALSE);

        //кодом выше создается новый заказ..строкой ниже он вносится в БД и получает id
        bookingDAO.insert(newBooking);
        //↓ без нижней строки объект BOOK засетится в сессию без ID
        newBooking = bookingDAO.getBookingByIdUser(loginId);
        bookingDAO.close();

        request.getSession().setAttribute("book", newBooking);

        return "/processJSP/userFrame/answerToBooking.jsp";
    }

}
