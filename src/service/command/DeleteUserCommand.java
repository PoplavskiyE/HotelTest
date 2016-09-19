/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.command;

import utils.FillAdminFrameForm;
import dao.BookingDAO;
import dao.RoomDAO;
import dao.UserDAO;
import javax.servlet.http.HttpServletRequest;
import models.Booking;
import models.User;

/**
 *
 * @author Женя
 */
public class DeleteUserCommand implements BaseCommandI {

    @Override
    public String execute(HttpServletRequest request) {

        BookingDAO bookingDAO = new BookingDAO();
        //удаление заказов удаляемого пользователя(если они были)
        Booking indexBooking = bookingDAO.getBookingByIdUser(Integer.valueOf(request.getParameter("userId")));
        if (indexBooking != null) {
            RoomDAO roomDAO = new RoomDAO();
            roomDAO.setStatusRoomNotOcup(indexBooking);
            roomDAO.close();
            bookingDAO.delete(indexBooking);
            bookingDAO.close();
        }

        //удаление пользователя
        UserDAO userDAO = new UserDAO();
        User indexUser = userDAO.getUserById(Integer.valueOf(request.getParameter("userId")));
        userDAO.delete(indexUser);
        userDAO.close();

        return FillAdminFrameForm.fillFrameForm(request);
    }

}
