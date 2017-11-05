package org.elsys.ip.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.elsys.ip.servlet.model.User;
import org.elsys.ip.servlet.service.UserService;

@WebServlet("/findUser")
public class FindUserServlet extends HttpServlet {
  private UserService userService = new UserService();

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String name = request.getParameter("name");
      User user = userService.getByName(name);
      if (user != null) {
        response.sendRedirect("/user?name="+user.getName());
      }
  }

}
