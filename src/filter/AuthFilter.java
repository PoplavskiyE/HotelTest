package filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import org.apache.commons.lang3.StringUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Женя
 */
/*
 * @WebFilter(filterName = "authFilter", urlPatterns = {"/*"}, initParams = {
 * 
 * @WebInitParam(name = "encoding", value = "UTF-8", description =
 * "Encoding Param") })
 */
public class AuthFilter implements Filter {

	private List<String> pathFilters = Arrays
			.asList(new String[] { "answerToOrder.jsp", "newOrder.jsp", "AdminFrame.jsp", });

	public AuthFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String uri = ((HttpServletRequest) request).getRequestURI();
		String path = StringUtils.substringAfterLast(uri, "/");

		// если в массиве pathFilters НЕ содержится uri
		// из запроса, то продолжить выполнение
		// запроса
		if (!pathFilters.contains(path)) {
			chain.doFilter(request, response);
			return;
		}
		// перехват запроса к любому ресурсу(за
		// исключением указанных в pathFilters)
		HttpSession session = ((HttpServletRequest) request).getSession();
		User user = (User) session.getAttribute("CurrentUser");
		// если получен User(выполнена
		// авторизация), то продолжение
		// выполнение запроса
		if (user != null) {
			chain.doFilter(request, response);
			return;
		}
		// Если авторизация не
		// выполнена(user=null),то редирект на
		// страницу регистрации
		((HttpServletResponse) response).sendRedirect("/HotelTest/index.html?net_takou_user");
	}

	@Override
	public void destroy() {
	}

}
