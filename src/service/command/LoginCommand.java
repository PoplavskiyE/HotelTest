/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.command;

import utils.FillAdminFrameForm;
import dao.BookingDAO;
import dao.UserDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import models.Booking;
import models.User;

/**
 *
 * @author Женя
 */
public class LoginCommand implements BaseCommandI {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = null;
        BookingDAO bookingDAO = null;

        if (username != null && password != null) {
            userDAO = new UserDAO();
            User user = userDAO.getUserByNameAndPass(username, password);
            userDAO.close();
            if (user != null) {
                session.setAttribute("CurrentUser", user);
                //если user == admin
                if (username.equals("a") && password.equals("1")) {
                    return FillAdminFrameForm.fillFrameForm(request);
                }
                //проверка на уже сделанные заказы
                bookingDAO = new BookingDAO();
                Booking book = bookingDAO.getBookingByIdUser(user.getId());
                bookingDAO.close();

                if (book != null) {
                    session.setAttribute("book", book);
                    return "/processJSP/userFrame/answerToBooking.jsp";
                }
                // response.sendRedirect("folder/AdminFrame.jsp");
                //какая разница ??? ↓↑
                //getServletContext().getRequestDispatcher("/servlets/adminFrame").forward(request, response);
                return "/processJSP/userFrame/newBooking.jsp";
            }//else нет такого Usera
        }
        return "/enterJSP/login.jsp?username=null||password=null";
    }

}
