/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.BookingDAO;
import dao.RoomDAO;
import dao.UserDAO;
import form.AdminFrameForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Женя
 */
public class FillAdminFrameForm {

	public static String fillFrameForm(HttpServletRequest request) {

		AdminFrameForm afForm = new AdminFrameForm();

		BookingDAO bookingDAO = new BookingDAO();
		List bookings = bookingDAO.getAll();
		bookingDAO.close();
		afForm.setBookings(bookings);

		UserDAO userDAO = new UserDAO();
		List users = userDAO.getAll();
		userDAO.close();
		afForm.setUsers(users);

		RoomDAO roomDAO = new RoomDAO();
		List rooms = roomDAO.getAll();
		roomDAO.close();
		afForm.setRooms(rooms);

		request.setAttribute("afForm", afForm);
		return "/processJSP/adminFrame/AdminFrame.jsp";
	}

}
