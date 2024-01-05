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


@WebServlet("/Categories")
public class Categories extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Categories() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/pages/categories.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		var adminBean=(AdminBean)session.getAttribute("adminBean");
		if (adminBean == null || !adminBean.isLoggedIn()) {
			address = "/WEB-INF/pages/login.jsp";
		}
		else if(action==null || action.equals("")) {//pocetak
			address="/WEB-INF/pages/categories.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
