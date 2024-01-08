package org.unibl.etf.dao;

import java.sql.SQLException;
import java.util.List;

import org.unibl.etf.models.dto.Advisor;

public interface AdvisorDAO {
	List<Advisor> findAll()throws SQLException;
	boolean updateStatus(Long id,boolean status)throws SQLException;
	boolean insert(Advisor a)throws SQLException;
}
