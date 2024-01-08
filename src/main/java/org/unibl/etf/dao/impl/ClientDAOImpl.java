package org.unibl.etf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.ClientDAO;
import org.unibl.etf.models.dto.Client;
import org.unibl.etf.utils.ConnectionPool;
import org.unibl.etf.utils.DBUtil;


public class ClientDAOImpl implements ClientDAO {
	
	private ConnectionPool connectionPool;
	private static final String FIND_ALL_QUERY="select * from client";
	private static final String UPDATE_CLIENT_QUERY = "update client c set status=? where c.id=?";
	
	public ClientDAOImpl() {
		this.connectionPool=ConnectionPool.getInstance();
	}

	@Override
	public List<Client> findAll()throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Client> result = new ArrayList<>();
		try {
			connection=connectionPool.checkOut();
			statement = DBUtil.prepareStatement(connection, FIND_ALL_QUERY, false, new Object[0]);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				result.add(new Client(resultSet.getLong("id"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("name"),
						resultSet.getString("surname"),resultSet.getString("city"),resultSet.getString("email"),resultSet.getBoolean("status")));
			}
			
		} finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement, resultSet);
		}
		return result;
	}

	@Override
	public boolean updateStatus(Long id, boolean status) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		Object[]values= {status,id};
		boolean result=false;
		try {
			connection=connectionPool.checkOut();
			statement = DBUtil.prepareStatement(connection, UPDATE_CLIENT_QUERY, false,values);
			result=statement.executeUpdate()==1;
		}
		finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement);
		}
		return result;
	}

}
