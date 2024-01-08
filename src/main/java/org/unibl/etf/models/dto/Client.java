package org.unibl.etf.models.dto;

import java.io.Serializable;
import java.util.Objects;

public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private String city;
	private String email;
	private boolean status;
	
	public Client() {
		super();
	}

	public Client(String username, String password, String name, String surname, String city, String email,boolean status) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.email = email;
		this.status=status;
	}

	public Client(Long id, String username, String password, String name, String surname, String city, String email,boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.email = email;
		this.status=status;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
		
}
