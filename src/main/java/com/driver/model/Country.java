package com.driver.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Note: Do not write @Enumerated annotation above CountryName in this model.
@Entity
@Table(name="table")
public class Country{
	private int id;
	//@Enumerated(value=EnumType.STRING)
	private CountryName countryName;
	private String code;
	@OneToOne(mappedBy="user" , cascade=CascadeType.ALL)
	private User user;
	@ManyToOne
	@JoinColumn
	private ServiceProvider serviceProvider;
	public Country(int id, CountryName countryName, String code, User user, ServiceProvider serviceProvider) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.code = code;
		this.user = user;
		this.serviceProvider = serviceProvider;
	}
	public Country() {
		super();
	}
	public int getId() {
		return id;
	}
	public CountryName getCountryName() {
		return countryName;
	}
	public String getCode() {
		return code;
	}
	public User getUser() {
		return user;
	}
	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCountryName(CountryName countryName) {
		this.countryName = countryName;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	
	
}
