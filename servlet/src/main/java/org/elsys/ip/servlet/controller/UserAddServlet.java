package org.elsys.ip.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.elsys.ip.servlet.model.User;
import org.elsys.ip.servlet.service.UserService;

@WebServlet("/addUser")
public class UserAddServlet extends HttpServlet {
  private UserService userService = new UserService();

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      long id = Long.parseLong(request.getParameter("id"));
      String name = request.getParameter("name");
      String mail = request.getParameter("mail");
      User user = new User(id, name, mail);
      userService.addUser(user);
      response.sendRedirect("/admin");
  }

}
