package doantheanh.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Helloworld
 */
// @WebServlet(description = "this is demo", urlPatterns = { "/start" })
public class Helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Helloworld() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		loadParameter(request, response, "Get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		loadParameter(request, response, "Post");
	}

	private void loadParameter(HttpServletRequest request, HttpServletResponse response, String method)
			throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		String appParam = context.getInitParameter("appParam");
		
		ServletConfig config = this.getServletConfig();
		String song = config.getInitParameter("song");
		
		PrintWriter writer = response.getWriter();
		writer.println("Hello The Anh:::  By " + method + "<br/>");
		writer.println("The Song::: " + song + "<br/>");
		writer.println("The appParam::: " + appParam + "<br/>");
	}

}
