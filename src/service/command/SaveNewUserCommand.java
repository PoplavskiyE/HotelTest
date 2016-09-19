/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.command;

import dao.UserDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import models.User;
import utils.ValidDataForRegistration;

/**
 *
 * @author Женя
 */
public class SaveNewUserCommand implements BaseCommandI {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        User user = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = "";
        String phone = "";

        HttpSession session = request.getSession();

        if (username != "") {
            session.removeAttribute("incorrectUsername");
            if (password != "") {
                session.removeAttribute("incorrectPassword");
                email = request.getParameter("email");
                if (email != "" && ValidDataForRegistration.ValidEmail(email)/*проверка валидности email*/) {
                    session.removeAttribute("incorrectEmail");
                    phone = request.getParameter("phone");
                    if (phone != "" && ValidDataForRegistration.ValidPhone(phone)/*проверка валидности телефона*/) {
                        session.removeAttribute("incorrectPhone");
                        UserDAO userDAO = new UserDAO();
                        user = userDAO.getUserByName(username);
                        //если БД не вернула usera с такими инициалами,то
                        if (user == null) {
                            session.removeAttribute("alreadyExist");
                            user = new User(username, password, email, phone);
                            userDAO.insert(user);
                            userDAO.close();
                            session.setAttribute("CurrentUser", user);
                            page = "/processJSP/userFrame/newBooking.jsp";
                            return page;
                        } else {
                            session.setAttribute("alreadyExist", "!!user is already exist!!");
                        }
                    } else {
                        session.setAttribute("incorrectPhone", "!!Format phone number is incorrect!!");
                    }
                } else {
                    session.setAttribute("incorrectEmail", "!!Format email is incorrect!!");
                }
            } else {
                session.setAttribute("incorrectPassword", "!!Incorrect format of password!!");
            }
        } else {
            session.setAttribute("incorrectUsername", "!!Enter login!!");
        }
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        session.setAttribute("email", email);
        session.setAttribute("phone", phone);
        //session.setAttribute("commonError", "Что-то не то!!!");
        //session.invalidate();
        return page = "/enterJSP/registration.jsp";
    }

}
