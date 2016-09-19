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
public class RegistrationCommand implements BaseCommandI {

    @Override
    public String execute(HttpServletRequest request) {
        return "/enterJSP/registration.jsp";
    }

}
