package org.unibl.etf.dao;

import java.sql.SQLException;

import org.unibl.etf.models.dto.Admin;

public interface AdminDAO {
	 Admin login(String username,String password)throws SQLException;

}
