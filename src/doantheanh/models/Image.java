package doantheanh.models;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Image implements HttpSessionBindingListener {
	private String name;
	private int width;
	private int height;

	public Image(String name, int width, int height) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		event.getSession().getServletContext().log("Image in the Session:: " + getName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		event.getSession().getServletContext().log("Image out the Session:: " + getName());
	}

}
