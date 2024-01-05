package org.unibl.etf.models.beans;

import java.io.Serializable;

import org.unibl.etf.dao.AdminDAO;
import org.unibl.etf.dao.impl.AdminDAOImpl;
import org.unibl.etf.models.dto.Admin;

public class AdminBean implements Serializable {
	private Admin admin;
	private boolean isLoggedIn = false;
	private AdminDAO adminDAO;

	public AdminBean() {
		this.adminDAO = new AdminDAOImpl();
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public boolean login(String username, String password) {
		try {
			var admin = adminDAO.login(username, password);
			if (admin!=null && admin.getPassword().equals(password)) {
				this.admin = admin;
				this.isLoggedIn=true;
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
