package org.unibl.etf.dao;

import java.sql.SQLException;
import java.util.List;

import org.unibl.etf.models.dto.Category;
import org.unibl.etf.models.dto.CategoryAttribute;

public interface CategoryAttributeDAO {
	List<CategoryAttribute> findAll(Long id)throws SQLException;
	CategoryAttribute insert(Long id,CategoryAttribute request)throws SQLException;
	boolean delete(Long id)throws SQLException;
	boolean update(CategoryAttribute category)throws SQLException;
}
