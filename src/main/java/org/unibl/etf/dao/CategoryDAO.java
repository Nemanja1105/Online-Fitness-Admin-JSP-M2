package org.unibl.etf.dao;

import java.sql.SQLException;
import java.util.List;

import org.unibl.etf.models.dto.Category;

public interface CategoryDAO {
	List<Category> findAll()throws SQLException;
	Category insert(Category request)throws SQLException;
	boolean delete(Long id)throws SQLException;
	boolean update(Category category)throws SQLException;
}
