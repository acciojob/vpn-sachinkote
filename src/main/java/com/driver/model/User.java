package com.driver.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String originalIp;
	private String maskedIp;
	private Boolean connected;
	private String originalCountry;
	
	

	@JoinColumn
	@ManyToMany
	private List<ServiceProvider> serviceProviderList;
	@OneToMany( cascade=CascadeType.ALL)
	private List<Connection> connectionList;
	@JoinColumn
	@OneToOne
	private Country country;
	
	
	public User(int id, String username, String password, String originalIp, String maskedIp, Boolean connected,
			List<ServiceProvider> serviceProviderList, List<Connection> connectionList, Country country) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.originalIp = originalIp;
		this.maskedIp = maskedIp;
		this.connected = connected;
		this.serviceProviderList = serviceProviderList;
		this.connectionList = connectionList;
		this.country = country;
	}

	public User() {
		super();
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

	public String getOriginalIp() {
		return originalIp;
	}

	public String getMaskedIp() {
		return maskedIp;
	}

	public Boolean getConnected() {
		return connected;
	}

	public List<ServiceProvider> getServiceProviderList() {
		return serviceProviderList;
	}

	public List<Connection> getConnectionList() {
		return connectionList;
	}

	public Country getCountry() {
		return country;
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

	public void setOriginalIp(String originalIp) {
		this.originalIp = originalIp;
	}

	public void setMaskedIp(String maskedIp) {
		this.maskedIp = maskedIp;
	}

	public void setConnected(Boolean connected) {
		this.connected = connected;
	}

	public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
		this.serviceProviderList = serviceProviderList;
	}

	public void setConnectionList(List<Connection> connectionList) {
		this.connectionList = connectionList;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public String getOriginalCountry() {
		return originalCountry;
	}

	public void setOriginalCountry(String originalCountry) {
		this.originalCountry = originalCountry;
	}
	

}
