package org.unibl.etf.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.LogDAO;
import org.unibl.etf.models.dto.Category;
import org.unibl.etf.models.dto.Log;
import org.unibl.etf.models.dto.LogLevel;
import org.unibl.etf.utils.ConnectionPool;
import org.unibl.etf.utils.DBUtil;

public class LogDAOImpl implements LogDAO {
	
	private ConnectionPool connectionPool;
	private final String FIND_ALL="select * from log limit ? offset ?";
	private final String COUNT_QUERY="select count(*) as count from log";

	public LogDAOImpl() {
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public List<Log> findAll(int page, int size) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Log> result = new ArrayList<>();
		
		Object[] values= {size,size*(page-1)};
		try {
			connection=connectionPool.checkOut();
			statement = DBUtil.prepareStatement(connection, FIND_ALL, false, values);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				result.add(new Log(LogLevel.values()[resultSet.getInt("level")],resultSet.getDate("date"),resultSet.getString("description")));
			}
			
		} finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement, resultSet);
		}
		return result;
	}

	@Override
	public int numberOfLogs() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int result=0;
		try {
			connection=connectionPool.checkOut();
			statement = DBUtil.prepareStatement(connection, COUNT_QUERY, false, new Object[0]);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				result=resultSet.getInt("count");
			}
			
		} finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement, resultSet);
		}
		return result;
	}
}
