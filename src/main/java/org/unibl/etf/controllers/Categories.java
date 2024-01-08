package org.unibl.etf.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.compiler.NewlineReductionServletWriter;
import org.unibl.etf.models.beans.AdminBean;
import org.unibl.etf.models.beans.CategoryAttributeBean;
import org.unibl.etf.models.beans.CategoryBean;
import org.unibl.etf.models.beans.Notification;
import org.unibl.etf.models.dto.Category;
import org.unibl.etf.models.dto.CategoryAttribute;

@WebServlet("/Categories")
public class Categories extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/pages/categories.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		var adminBean = (AdminBean) session.getAttribute("adminBean");
		var categoryBean = (CategoryBean) session.getAttribute("categoryBean");
		var categoryAttributeBean=(CategoryAttributeBean)session.getAttribute("categoryAttributeBean");
		session.setAttribute("notification",null);
		session.setAttribute("active", "Categories");
		if (adminBean == null || !adminBean.isLoggedIn()) {
			response.sendRedirect("Login");
			return;
		} 
		if (action == null || action.equals("")) {// pocetak
			address = "/WEB-INF/pages/categories.jsp";
		} else if ("add".equals(action)) {
			var name = request.getParameter("name");
			var tmp= categoryBean.insert(new Category(name));
			if(tmp!=null) {
				session.setAttribute("notification",new Notification("Category successfully added", true));
			}
			else {
				session.setAttribute("notification",new Notification("Category was not successfully added", false));
			}
		} else if ("delete".equals(action)) {
			try {
				var id = Long.parseLong(request.getParameter("id"));
				if (categoryBean.delete(id))
					session.setAttribute("notification",new Notification("Category successfully deleted", true));
				else 
					session.setAttribute("notification",new Notification("Category was not successfully deleted", false));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if("update".equals(action)) {
			try {
				var id = Long.parseLong(request.getParameter("id"));
				var name=request.getParameter("name");
				if(categoryBean.update(new Category(id, name)))
					session.setAttribute("notification",new Notification("Category successfully updated", true));
				else 
					session.setAttribute("notification",new Notification("Category was not successfully updated", false));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if("add_attribute".equals(action)) {
			try {
				var id = Long.parseLong(request.getParameter("id"));
				var name=request.getParameter("name");
				var tmp= categoryAttributeBean.insert(id, new CategoryAttribute(name, id));
				if(tmp!=null)
					session.setAttribute("notification",new Notification("Category attribute successfully added", true));
				else
					session.setAttribute("notification",new Notification("Category attribute was not successfully added", false));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if("delete_attribute".equals(action)) {
			try {
				var id = Long.parseLong(request.getParameter("id"));
				if(categoryAttributeBean.delete(id))
					session.setAttribute("notification",new Notification("Category attribute successfully deleted", true));
				else
					session.setAttribute("notification",new Notification("Category attribute was not successfully deleted", false));
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if("update_attribute".equals(action)) {
			try {
				var id = Long.parseLong(request.getParameter("id"));
				var name=request.getParameter("name");
				if(categoryAttributeBean.update(new CategoryAttribute(id, name)))
					session.setAttribute("notification",new Notification("Category attribute successfully updated", true));
				else
					session.setAttribute("notification",new Notification("Category attribute was not successfully updated", false));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			address="404.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
