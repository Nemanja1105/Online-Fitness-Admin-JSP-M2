package org.unibl.etf.dao;

import java.sql.SQLException;
import java.util.List;

import org.unibl.etf.models.dto.Client;

public interface ClientDAO {
	List<Client> findAll()throws SQLException;
	boolean updateStatus(Long id,boolean status)throws SQLException;

}
