/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.command;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Женя
 */
public class LogOutCommand implements BaseCommandI {

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        //request.setAttribute("LogOut", "LogOut Successfull");
        return "/enterJSP/login.jsp";
    }

}
