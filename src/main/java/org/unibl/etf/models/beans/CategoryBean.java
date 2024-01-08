package org.unibl.etf.models.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.CategoryDAO;
import org.unibl.etf.dao.impl.CategoryDAOImpl;
import org.unibl.etf.models.dto.Category;

public class CategoryBean implements Serializable {

	private CategoryDAO categoryDAO;
	
	public CategoryBean() {
		this.categoryDAO=new CategoryDAOImpl();
	}

	public List<Category> findAll() {
		List<Category> result = new ArrayList<>();
		try {
			result = this.categoryDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Category insert(Category request) {
		try {
			return this.categoryDAO.insert(request);
		} catch (SQLException e) {
			return null;
		}
	}
	
	public boolean delete(Long id) {
		try {
			return this.categoryDAO.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Category request) {
		try {
			return this.categoryDAO.update(request);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
