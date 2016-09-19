/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.command;

import dao.BookingDAO;
import javax.servlet.http.HttpServletRequest;
import models.Booking;

/**
 *
 * @author Женя
 */
public class NewBookingCommand implements BaseCommandI {

    @Override
    /**
     * Delete current order and Return path to newBooking frame.
     */
    public String execute(HttpServletRequest request) {
        Booking book = (Booking) request.getSession().getAttribute("book");
        BookingDAO bookingDAO = new BookingDAO();
        bookingDAO.delete(book);
        bookingDAO.close();
        return "/processJSP/userFrame/newBooking.jsp";
    }

}
