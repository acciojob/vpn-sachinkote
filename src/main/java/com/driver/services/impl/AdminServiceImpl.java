package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.Connection;
import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.model.User;
import com.driver.repository.AdminRepository;

import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin register(String username, String password) {
    	Admin admin=new Admin();
    	admin.setPassword(password);
    	admin.setUsername(username);
    	List<ServiceProvider> l= new ArrayList<>();
    	admin.setServiceProvider(l);
		return adminRepository1.save(admin);
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName) {
    	Admin admin=adminRepository1.findById(adminId).get();
    	ServiceProvider provider=new ServiceProvider();
    	provider.setAdmin(admin);
    	provider.setName(providerName);
    	List<Connection>connectionList =new ArrayList<>(); 
    	provider.setConnectionList(connectionList);
    	List<Country>countryList =new ArrayList<>(); 
    	provider.setCountryList(countryList);
    	List<User>userList =new ArrayList<>(); 
    	provider.setUsers(userList);
    	
    	List<ServiceProvider> l=admin.getServiceProvider();
    	l.add(provider);
    	
    	adminRepository1.save(admin);
		return admin;
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{
    	ServiceProvider provider=serviceProviderRepository1.findById(serviceProviderId).get();
    	Country c=new Country();
        CountryName list[]= CountryName.values();
        for(CountryName name:list)
        {
        	if(name.equals(countryName))
        	{
        		c.setCountryName(name);
        		
        		c.setCode(name.toCode());
        	}
        }
        User u=new User();
        c.setUser(u);
        List<Country> l=provider.getCountryList();
        l.add(c);
        serviceProviderRepository1.save(provider);
       
    	
		return provider;
    }
}
