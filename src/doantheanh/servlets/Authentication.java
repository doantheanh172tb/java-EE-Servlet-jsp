package doantheanh.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doantheanh.models.DatabaseManagement;

/**
 * Servlet implementation class Authentication
 */
// @WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentication() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		PrintWriter writer = response.getWriter();
		
		DatabaseManagement dm = new DatabaseManagement();
		
		if (dm.checkUser(userName, password)) {
			request.setAttribute("userName", userName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/imageshow");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
