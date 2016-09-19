/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.command.factory;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import service.command.BaseCommandI;
import service.command.client.CommandEnum;

/**
 *
 * @author Женя
 */
public class ActionFactory {

    public BaseCommandI defineCommand(HttpServletRequest request) {
        BaseCommandI current = null;
        Enumeration<String> allCurrentCommand = request.getParameterNames();
        if (allCurrentCommand.equals(null)) {
            return current;
        }
        while (allCurrentCommand.hasMoreElements()) {
            String nextElement = allCurrentCommand.nextElement();
            try {
                CommandEnum currentEnum = CommandEnum.valueOf(nextElement.toUpperCase());
                if (currentEnum != null) {
                    return current = currentEnum.getCurrentCommand();
                }
            } catch (IllegalArgumentException ex) {
                System.err.println(ex);
            }
        }
        return current;
    }
}
