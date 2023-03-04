package com.driver.services.impl;

import com.driver.model.Connection;
import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.model.User;

import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;

import java.util.ArrayList;
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
    	user.setUsername(username);
    	user.setPassword(password);
    	Country c=new Country();
    	
    	String name=countryName.toUpperCase();
    	if(name.equals("IND")) {
    		c.setCountryName(CountryName.IND);
    		c.setCode(CountryName.IND.toCode());
    		user.setMaskedIp(""+CountryName.IND.toCode()+"."+user.getId());
    	}
    	else if(name.equals("AUS"))
    	{
    		c.setCountryName(CountryName.AUS);
    		c.setCode(CountryName.AUS.toCode());
    		user.setMaskedIp(""+CountryName.AUS.toCode()+"."+user.getId());
    	}
    	else if(name.equals("CHI"))
    	{
    		c.setCountryName(CountryName.CHI);
    		c.setCode(CountryName.CHI.toCode());
    		user.setMaskedIp(""+CountryName.CHI.toCode()+"."+user.getId());
    	}
    	else if(name.equals("JPN"))
    	{
    		c.setCountryName(CountryName.JPN);
    		c.setCode(CountryName.JPN.toCode());
    		user.setMaskedIp(""+CountryName.JPN.toCode()+"."+user.getId());
    	}
    	else if(name.equals("USA"))
    	{
    		c.setCountryName(CountryName.USA);
    		c.setCode(CountryName.USA.toCode());
    		user.setMaskedIp(""+CountryName.USA.toCode()+"."+user.getId());
    	}
    	c.setServiceProvider(null);
    	user.setConnected(false);
    	List<Connection>l=new ArrayList<>();
    	user.setConnectionList(l);
    	user.setMaskedIp(null);
    	user.setOriginalCountry(name);
		user.setCountry(c);
		
		//userRepository3.save(user);
		c.setUser(user);
		countryRepository3.save(c);
       return user;
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
