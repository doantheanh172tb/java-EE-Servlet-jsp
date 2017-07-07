package doantheanh.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class WebsiteSession implements HttpSessionListener {

	private static int numberOfSession = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().getServletContext().log("----- A new Session was created " + ++numberOfSession);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		se.getSession().getServletContext().log("----- A new Session was destroyed " + --numberOfSession);
	}

}
