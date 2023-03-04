package com.driver.services.impl;

import com.driver.model.Connection;
import com.driver.model.ServiceProvider;
import com.driver.model.User;

import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository3;
    @Autowired
    ServiceProviderRepository serviceProviderRepository3;
    @Autowired
    CountryRepository countryRepository3;

    @Override
    public User register(String username, String password, String countryName) throws Exception{
    	User user=new User();
    	user.setConnected(false);
    	List<Connection> l=null;
    	user.setConnectionList(l);
    	user.setCountry(null);
    	user.setMaskedIp(null);
    	//user.setOriginalIp(user.getCountry().getCountryName().toCode()+"."+user.getId());
    	user.setUsername(username);
    	user.setPassword(password);
    	List<ServiceProvider> l2=null;
    	user.setServiceProviderList(l2);
    	return userRepository3.save(user);
    	
		

    }

    @Override
    public User subscribe(Integer userId, Integer serviceProviderId) {
		User user=userRepository3.findById(userId).get();
		List<ServiceProvider>l1=user.getServiceProviderList();
		ServiceProvider sp=serviceProviderRepository3.findById(serviceProviderId).get();
		List<User> l=sp.getUsers();
		
		l.add(user);
		sp.setUsers(l);
		l1.add(sp);
		user.setServiceProviderList(l1);
		
		userRepository3.save(user);
		serviceProviderRepository3.save(sp);
		return user;
    }
}
