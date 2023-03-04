package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="connection")
public class Connection {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;
@ManyToOne
@JoinColumn
private User user;
@ManyToOne
@JoinColumn
private ServiceProvider serviceProvider;
public Connection() {
	super();
}
public Connection(int id, User user, ServiceProvider serviceProvider) {
	super();
	this.id = id;
	this.user = user;
	this.serviceProvider = serviceProvider;
}
public int getId() {
	return id;
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
public void setUser(User user) {
	this.user = user;
}
public void setServiceProvider(ServiceProvider serviceProvider) {
	this.serviceProvider = serviceProvider;
}


}
