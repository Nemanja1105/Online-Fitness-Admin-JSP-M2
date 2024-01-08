package org.unibl.etf.models.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.AdvisorDAO;
import org.unibl.etf.dao.impl.AdvisorDAOImpl;
import org.unibl.etf.models.dto.Advisor;

public class AdvisorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private AdvisorDAO advisorDAO;
	
	public AdvisorBean() {
		this.advisorDAO=new AdvisorDAOImpl();
	}
	
	public List<Advisor> findAll(){
		List<Advisor> result = new ArrayList<>();
		try {
			result = this.advisorDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean block(Long id) {
		try {
			return this.advisorDAO.updateStatus(id, false);
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean unblock(Long id) {
		try {
			return this.advisorDAO.updateStatus(id, true);
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean insert(Advisor a) {
		try {
			return this.advisorDAO.insert(a);
		} catch (Exception e) {
			return false;
		}
	}

}
