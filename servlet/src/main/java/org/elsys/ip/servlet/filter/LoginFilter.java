package org.elsys.ip.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;


		boolean authorized = false;
		boolean coockiFound = false;

		Cookie[] cookies = httpServletRequest.getCookies();
		if (cookies != null) {
			for (Cookie cookieee : cookies) {
				if (cookieee.getName().equals("logged")) {
					coockiFound = true;
				}
			}
		}
		if (coockiFound == false) {
			if (request.getParameter("password") == null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				return;
			}
			// check username and password (can be hardcoded, can use the userService)
			// add if the person is logged in to a cookie (Google it), so that we do not check at every page
			String username = request.getParameter("name");
			String password = request.getParameter("password");

			if (username.equals("123") && password.equals("kappa")) {
				authorized = true;
			}
			if (authorized) {
				Cookie cookie = new Cookie("logged", "123");
				httpServletResponse.addCookie(cookie);
				chain.doFilter(request, response);
			} else {
				request.setAttribute("error", "Wrong username or password!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			chain.doFilter(request, response);
			return;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
