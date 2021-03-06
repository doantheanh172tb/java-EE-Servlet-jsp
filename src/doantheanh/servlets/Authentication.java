package doantheanh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import doantheanh.models.DatabaseManagement;
import doantheanh.models.Image;

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
			response.addCookie(new Cookie("location", "VietNam"));
			
			HttpSession session = request.getSession();
			//session.setMaxInactiveInterval(900);setTimeOut by minisecon
			
			session.setAttribute("userName", userName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/imageshow");
			Image funnyImage = new Image("Baby", 200, 300);
			request.setAttribute("imageName", funnyImage);
			
			session.setAttribute("testImage", new Image("testing image", 200, 300));
			session.removeAttribute("test");
			
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
