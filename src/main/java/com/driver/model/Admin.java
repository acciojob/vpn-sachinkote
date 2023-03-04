package com.driver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	@OneToMany(mappedBy="serviceprovider", cascade=CascadeType.ALL)
	private List<ServiceProvider> serviceProviders=new ArrayList<>();
	
	public Admin() {
		super();
	}


	


	public Admin(int id, String username, String password, List<ServiceProvider> serviceProviders) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.serviceProviders = serviceProviders;
	}





	public int getId() {
		return id;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}





	public List<ServiceProvider> getServiceProviders() {
		return serviceProviders;
	}





	public void setServiceProvider(List<ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}
	
	
	
	
}
