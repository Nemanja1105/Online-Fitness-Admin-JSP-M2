package org.unibl.etf.dao.impl;

import java.security.KeyStore.PrivateKeyEntry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.CategoryDAO;
import org.unibl.etf.models.dto.Admin;
import org.unibl.etf.models.dto.Category;
import org.unibl.etf.utils.ConnectionPool;
import org.unibl.etf.utils.DBUtil;

public class CategoryDAOImpl implements CategoryDAO{
	
	private ConnectionPool connectionPool;
	private static final String FIND_ALL_QUERY="select * from category where status=true";
	private static final String INSERT_CATEGORY_QUERY="insert into category(name,status) values(?, ?)";
	private static final String DELETE_CATEGORY_QUERY = "update category c set status=? where c.id=? ";
	private static final String UPDATE_CATEGORY_QUERY = "update category c set name=? where c.id=?";
	
	public CategoryDAOImpl() {
		this.connectionPool=ConnectionPool.getInstance();
	}

	@Override
	public List<Category> findAll()throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Category> result = new ArrayList<>();
		try {
			connection=connectionPool.checkOut();
			statement = DBUtil.prepareStatement(connection, FIND_ALL_QUERY, false, new Object[0]);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				result.add(new Category(resultSet.getLong(1),resultSet.getString(2)));
			}
			
		} finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement, resultSet);
		}
		return result;
	}

	@Override
	public Category insert(Category request)throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Category result = null;
		Object[]values= {request.getName(),true};
		try {
			connection=connectionPool.checkOut();
			statement = DBUtil.prepareStatement(connection, INSERT_CATEGORY_QUERY, true,values);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			result=request;
			if(resultSet.next())
				result.setId(resultSet.getLong(1));
				
		}
		finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement, resultSet);
		}
		return result;
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		Object[]values= {false,id};
		boolean result=false;
		try {
			connection=connectionPool.checkOut();
			statement = DBUtil.prepareStatement(connection, DELETE_CATEGORY_QUERY, false,values);
			result=statement.executeUpdate()==1;
		}
		finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement);
		}
		return result;
		
	}

	@Override
	public boolean update(Category category) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		Object[]values= {category.getName(),category.getId()};
		boolean result=false;
		try {
			connection=connectionPool.checkOut();
			statement = DBUtil.prepareStatement(connection, UPDATE_CATEGORY_QUERY, false,values);
			result=statement.executeUpdate()==1;
		}
		finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement);
		}
		return result;
	}

}
