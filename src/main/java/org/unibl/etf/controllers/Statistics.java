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


@WebServlet("/Statistics")
public class Statistics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Statistics() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/pages/Statistics.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		var adminBean = (AdminBean) session.getAttribute("adminBean");
		session.setAttribute("notification", null);
		session.setAttribute("active", "Statistics");
		session.setAttribute("currentPage", Integer.valueOf(1));
		var page=request.getParameter("page");

		if (adminBean == null || !adminBean.isLoggedIn()) {
			response.sendRedirect("Login");
			return;
		}
		if (action == null || action.equals(""))
			address = "/WEB-INF/pages/Statistics.jsp";
		if(page!=null && !page.isBlank()) {
			try {
				Integer p=Integer.parseInt(page);
				session.setAttribute("currentPage", p);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
