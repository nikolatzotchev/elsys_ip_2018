package org.elsys.ip.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    Cookie[] cookies = httpServletRequest.getCookies();
    if (cookies != null) {
      for (Cookie cookieee : cookies) {
        if (cookieee.getName().equals("logged")) {
          cookieee.setMaxAge(0);
          httpServletResponse.addCookie(cookieee);
          response.sendRedirect("/admin");
        }
      }
    }
  }
}
