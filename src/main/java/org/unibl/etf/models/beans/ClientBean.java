package org.unibl.etf.models.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.ClientDAO;
import org.unibl.etf.dao.impl.ClientDAOImpl;
import org.unibl.etf.models.dto.Client;

public class ClientBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO;
	
	public ClientBean() {
		this.clientDAO=new ClientDAOImpl();
	}
	
	public List<Client> findAll(){
		List<Client> result = new ArrayList<>();
		try {
			result = this.clientDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean block(Long id) {
		try {
			return this.clientDAO.updateStatus(id, false);
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean unblock(Long id) {
		try {
			return this.clientDAO.updateStatus(id, true);
		} catch (SQLException e) {
			return false;
		}
	}
	
	

}
