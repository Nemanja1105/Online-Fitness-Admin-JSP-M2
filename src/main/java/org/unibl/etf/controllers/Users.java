package org.unibl.etf.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.unibl.etf.models.beans.AdminBean;
import org.unibl.etf.models.beans.AdvisorBean;
import org.unibl.etf.models.beans.ClientBean;
import org.unibl.etf.models.beans.Notification;
import org.unibl.etf.models.dto.Advisor;

@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Users() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/pages/Users.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		var adminBean = (AdminBean) session.getAttribute("adminBean");
		var clientBean = (ClientBean) session.getAttribute("clientBean");
		var advisorBean=(AdvisorBean) session.getAttribute("advisorBean");
		session.setAttribute("notification", null);
		session.setAttribute("active", "Users");
		session.setAttribute("tab", 1);

		if (adminBean == null || !adminBean.isLoggedIn()) {
			response.sendRedirect("Login");
			return;
		}
		if (action == null || action.equals(""))
			address = "/WEB-INF/pages/Users.jsp";
		else if ("block_client".equals(action)) {
			try {
				var id = Long.parseLong(request.getParameter("id"));
				if (clientBean.block(id))
					session.setAttribute("notification", new Notification("Client successfully blocked", true));
				else
					session.setAttribute("notification", new Notification("Client was not successfully blocked", false));
				session.setAttribute("tab",1);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if ("unblock_client".equals(action)) {
			try {
				var id = Long.parseLong(request.getParameter("id"));
				if (clientBean.unblock(id))
					session.setAttribute("notification", new Notification("Client successfully unblocked", true));
				else
					session.setAttribute("notification", new Notification("Client was not successfully unblocked", false));
				session.setAttribute("tab",1);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if ("block_advisor".equals(action)) {
			try {
				var id = Long.parseLong(request.getParameter("id"));
				if (advisorBean.block(id))
					session.setAttribute("notification", new Notification("Advisor successfully blocked", true));
				else
					session.setAttribute("notification", new Notification("Advisor was not successfully blocked", false));
				session.setAttribute("tab",2);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if ("unblock_advisor".equals(action)) {
			try {
				var id = Long.parseLong(request.getParameter("id"));
				if (advisorBean.unblock(id))
					session.setAttribute("notification", new Notification("Advisor successfully unblocked", true));
				else
					session.setAttribute("notification", new Notification("Advisor was not successfully unblocked", false));
				session.setAttribute("tab",2);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if("insert_advisor".equals(action)) {
			var username=request.getParameter("username");
			var password=request.getParameter("password");
			var name=request.getParameter("name");
			var surname=request.getParameter("surname");
			var email=request.getParameter("email");
			var advisor=new Advisor(username, password, name, surname, email, true);
			if(advisorBean.insert(advisor))
				session.setAttribute("notification", new Notification("Advisor successfully added", true));
			else
				session.setAttribute("notification", new Notification("Advisor was not successfully added", false));
			session.setAttribute("tab",2);
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
