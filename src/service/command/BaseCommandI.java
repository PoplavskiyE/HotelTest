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
public interface BaseCommandI {

	String execute(
			HttpServletRequest request) /* throws SQLException, IOException */;
}
