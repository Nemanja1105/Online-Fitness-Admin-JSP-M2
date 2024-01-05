package org.unibl.etf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.unibl.etf.dao.AdminDAO;
import org.unibl.etf.models.dto.Admin;
import org.unibl.etf.utils.ConnectionPool;
import org.unibl.etf.utils.DBUtil;

public class AdminDAOImpl implements AdminDAO {

	private static final String LOGIN_QUERY = "select * from admin where username=? AND status=1";
	private ConnectionPool connectionPool;

	public AdminDAOImpl() {
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public Admin login(String username, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Object values[] = { username };
		Admin result = null;
		try {
			connection = connectionPool.checkOut();
			statement = DBUtil.prepareStatement(connection, LOGIN_QUERY, false, values);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				result = new Admin(resultSet.getLong(1), resultSet.getString(3), resultSet.getString(6),
						resultSet.getString(2), resultSet.getString(5));
			}
		} finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement, resultSet);
		}
		return result;
	}
}
