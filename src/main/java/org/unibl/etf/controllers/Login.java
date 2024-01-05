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
import org.unibl.etf.utils.ConnectionPool;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	ConnectionPool.initPool(getServletContext());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/pages/login.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		session.setAttribute("loginNotification", "");
		if(action==null || action.equals("")) {//pocetak
			address="/WEB-INF/pages/login.jsp";
		}
		else if("login".equals(action)) {
			var username=request.getParameter("username");
			var password=request.getParameter("password");
			AdminBean adminBean=new AdminBean();
			if(adminBean.login(username, password))
			{
				session.setAttribute("adminBean", adminBean);
				address="/WEB-INF/pages/categories.jsp";
			}
			else
				session.setAttribute("loginNotification","The user with the given username and password wasn't found!");	
		}
		else if("logout".equals(action)) {
			session.invalidate();
			response.sendRedirect("Login");
			return;
		}
		else {
			var adminBean=(AdminBean)session.getAttribute("adminBean");
			if (adminBean == null || !adminBean.isLoggedIn()) {
				address = "/WEB-INF/pages/login.jsp";
			}
			address="/WEB-INF/pages/categories.jsp";
			//address="/WEB-INF/pages/404.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
