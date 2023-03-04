package com.driver.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="serviceprovider")
public class ServiceProvider {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int id;
	private  String name;
	@JoinColumn
	@ManyToOne
	private Admin admin;
	
	@ManyToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<User> users;
	@OneToMany(mappedBy="connection", cascade=CascadeType.ALL)
	private List<Connection> connectionList;
	@OneToMany(mappedBy="country", cascade=CascadeType.ALL)
	private List<Country> countryList;
	
	public ServiceProvider() {
		super();
	}

	public ServiceProvider(int id, String name, Admin admin, List<User> users, List<Connection> connectionList,
			List<Country> countryList) {
		super();
		this.id = id;
		this.name = name;
		this.admin = admin;
		this.users = users;
		this.connectionList = connectionList;
		this.countryList = countryList;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Admin getAdmin() {
		return admin;
	}

	public List<User> getUsers() {
		return users;
	}

	public List<Connection> getConnectionList() {
		return connectionList;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setConnectionList(List<Connection> connectionList) {
		this.connectionList = connectionList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}
	
	

}
