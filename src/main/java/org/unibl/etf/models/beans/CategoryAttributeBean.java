package org.unibl.etf.models.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.CategoryAttributeDAO;
import org.unibl.etf.dao.impl.CategoryAttributeDAOImpl;
import org.unibl.etf.models.dto.Category;
import org.unibl.etf.models.dto.CategoryAttribute;

public class CategoryAttributeBean implements Serializable {
	
	private CategoryAttributeDAO categoryAttributeDAO;
	
	public CategoryAttributeBean() {
		this.categoryAttributeDAO=new CategoryAttributeDAOImpl();
	}
	
	public List<CategoryAttribute> findAll(Long id) {
		List<CategoryAttribute> result = new ArrayList<>();
		try {
			result = this.categoryAttributeDAO.findAll(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public CategoryAttribute insert(Long id,CategoryAttribute request) {
		try {
			return this.categoryAttributeDAO.insert(id,request);
		} catch (SQLException e) {
			return null;
		}
	}
	
	public boolean delete(Long id) {
		try {
			return this.categoryAttributeDAO.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(CategoryAttribute request) {
		try {
			return this.categoryAttributeDAO.update(request);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
