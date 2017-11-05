package org.elsys.ip.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.elsys.ip.servlet.model.User;
import org.elsys.ip.servlet.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  private UserService userService = new UserService();

  /**
   * @see HttpServlet#HttpServlet()
   */
  public UserServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    User user = userService.getByName(request.getParameter("name"));
    if (user != null) {
      out.print("Welcome, " + user.getName() + ". Your email is: " + user.getEmail());
      request.setAttribute("user", user);
      request.getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
    } else {
      out.println("Welcome, anonymous.");
    }
    out.close();
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String name = request.getParameter("name");
    String newName = request.getParameter("newName");
    String mail = request.getParameter("newMail");
    userService.changeUser(name, newName, mail);
    response.sendRedirect("/admin");
  }

}
