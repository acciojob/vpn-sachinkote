package com.driver.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Note: Do not write @Enumerated annotation above CountryName in this model.
@Entity
@Table(name="country")
public class Country{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private CountryName countryName;
	private String code;
	@OneToOne( cascade=CascadeType.ALL)
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
	
	public String getCode() {
		return code;
	}
	public User getUser() {
		return user;
	}
	
	public void setId(int id) {
		this.id = id;
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
	public CountryName getCountryName() {
		return countryName;
	}
	public void setCountryName(CountryName countryName) {
		this.countryName = countryName;
	}
	
}
