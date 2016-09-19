/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.command;

import utils.FillAdminFrameForm;
import dao.BookingDAO;
import dao.RoomDAO;
import javax.servlet.http.HttpServletRequest;
import models.Booking;

/**
 *
 * @author Женя
 */
public class DeleteBookingCommand implements BaseCommandI {

    @Override
    public String execute(HttpServletRequest request) {
        BookingDAO bookingDAO = new BookingDAO();
        RoomDAO roomDAO = new RoomDAO();

        if (request.getParameter("idBooking") != null) {
            Booking indexBooking = null;
            indexBooking = bookingDAO.getBookingById(Integer.valueOf(request.getParameter("idBooking")));
            roomDAO.setStatusRoomNotOcup(indexBooking);
            bookingDAO.delete(indexBooking);
        }
        return FillAdminFrameForm.fillFrameForm(request);
    }

}
