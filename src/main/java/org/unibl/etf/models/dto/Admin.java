package org.unibl.etf.models.dto;

import java.io.Serializable;
import java.util.Objects;

public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	private String name;
	private String surname;
	
	public Admin() {
		super();
	}
	public Admin(String username, String password, String name, String surname) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
	}
	public Admin(Long id, String username, String password, String name, String surname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
		Admin other = (Admin) obj;
		return Objects.equals(id, other.id);
	}
}
