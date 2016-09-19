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
public class MoveAwayCommand implements BaseCommandI {

    @Override
    public String execute(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("CurrentUser");
        Booking book = (Booking) request.getSession().getAttribute("book");
        
        BookingDAO bookingDAO = new BookingDAO();
        RoomDAO roomDAO = null;
        book = bookingDAO.getBookingByIdUser(currentUser.getId());
        // снять статус"занято" с комнаты
        roomDAO = new RoomDAO();
        roomDAO.setStatusRoomNotOcup(book);
        roomDAO.close();
        // удаление заказа из БД
        bookingDAO.delete(book);
        bookingDAO.close();
        return "/processJSP/userFrame/newBooking.jsp";
    }

}
