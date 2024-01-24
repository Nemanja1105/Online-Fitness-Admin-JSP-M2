package org.unibl.etf.dao;

import java.sql.SQLException;
import java.util.List;

import org.unibl.etf.models.dto.Log;

public interface LogDAO {

	List<Log> findAll(int page,int size)throws SQLException;
	int numberOfLogs() throws SQLException;
}
