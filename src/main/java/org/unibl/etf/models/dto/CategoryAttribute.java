package org.unibl.etf.models.dto;

import java.io.Serializable;
import java.util.Objects;

public class CategoryAttribute implements Serializable {
	private Long id;
	private String name;
	private Long categoryId;
	
	public CategoryAttribute() {
		super();
	}
	
	

	public CategoryAttribute(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public CategoryAttribute(String name,Long categoryId) {
		super();
		this.name = name;
		this.categoryId=categoryId;
	}

	public CategoryAttribute(Long id, String name,Long categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId=categoryId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryAttribute other = (CategoryAttribute) obj;
		return Objects.equals(id, other.id);
	}
	

}
