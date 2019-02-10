package org.fancypackage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fancypackage.dto.UserDTO;
import org.fancypackage.service.UserService;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet({ "/controller", "/ControllerServlet" })
public class ControllerServlet extends HttpServlet {

	UserService userService = new UserService();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("Hello from the GET-Method");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO user = userService.getUser(request.getParameter("userName"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("forwarded.jsp");
		System.out.println(user.getUserName() + user.getMobilePhoneNumber());
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
	}

}
