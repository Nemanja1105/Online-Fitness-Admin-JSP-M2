package org.unibl.etf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.CategoryAttributeDAO;
import org.unibl.etf.models.dto.Category;
import org.unibl.etf.models.dto.CategoryAttribute;
import org.unibl.etf.utils.ConnectionPool;
import org.unibl.etf.utils.DBUtil;

public class CategoryAttributeDAOImpl implements CategoryAttributeDAO {

	private ConnectionPool connectionPool;
	private static final String FIND_ALL_QUERY="select * from category_attribute where category_id=? and status=true";
	private static final String INSERT_CATEGORY_QUERY="insert into category_attribute(name,status,category_id) values(?, ?, ?)";
	private static final String DELETE_ATTRIBUTE_QUERY = "update category_attribute c set status=? where c.id=? ";
	private static final String UPDATE_ATTRIBUTE_QUERY = "update category_attribute c set name=? where c.id=?";
	
	public CategoryAttributeDAOImpl() {
		this.connectionPool=ConnectionPool.getInstance();
	}

	@Override
	public List<CategoryAttribute> findAll(Long id)throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<CategoryAttribute> result = new ArrayList<>();
		Object[]values= {id};
		try {
			connection=connectionPool.checkOut();
			statement = DBUtil.prepareStatement(connection, FIND_ALL_QUERY, false, values);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				result.add(new CategoryAttribute(resultSet.getLong(1),resultSet.getString(2),resultSet.getLong(3)));
			}
			
		} finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement, resultSet);
		}
		return result;
	}

	@Override
	public CategoryAttribute insert(Long id,CategoryAttribute request)throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		CategoryAttribute result = null;
		Object[]values= {request.getName(),true,id};
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
			statement = DBUtil.prepareStatement(connection, DELETE_ATTRIBUTE_QUERY, false,values);
			result=statement.executeUpdate()==1;
		}
		finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement);
		}
		return result;
	}

	@Override
	public boolean update(CategoryAttribute category) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		Object[]values= {category.getName(),category.getId()};
		boolean result=false;
		try {
			connection=connectionPool.checkOut();
			statement = DBUtil.prepareStatement(connection, UPDATE_ATTRIBUTE_QUERY, false,values);
			result=statement.executeUpdate()==1;
		}
		finally {
			connectionPool.checkIn(connection);
			DBUtil.close(statement);
		}
		return result;
	}
	


}
