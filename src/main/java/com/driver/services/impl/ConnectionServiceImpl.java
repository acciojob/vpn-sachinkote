package com.driver.services.impl;

import com.driver.model.*;
import com.driver.repository.ConnectionRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionServiceImpl implements ConnectionService {
    @Autowired
    UserRepository userRepository2;
    @Autowired
    ServiceProviderRepository serviceProviderRepository2;
    @Autowired
    ConnectionRepository connectionRepository2;

    @Override
    public User connect(int userId, String countryName) throws Exception{
    	User user=userRepository2.findById(userId);
    	if(user.getConnected()==true)
    		throw new Exception("Already connected");
    	else if(user.getCountry().getCountryName().equals(countryName))
    		return user;
    	else
    	{
    		if(user.getServiceProviderList().size()!=0) {
    			List<ServiceProvider> l=user.getServiceProviderList();
    			for(ServiceProvider p:l)
    			{
    				if(p.getCountryList().size()!=0) {
    					List<Country>list=p.getCountryList();
    					for(Country c:list)
    					{
    						if(c.getCountryName().equals(countryName))
    						{
    							 user.setConnected(Boolean.TRUE);	
    			    		     user.setMaskedIp(""+user.getCountry().getCountryName().toCode()+"."+p.getId()+"."+userId);
    						}
    					}
    				}
    			}
    			throw new Exception("Unable to connect");
    		}
    		
    	}
    	
    	
		return user;

    }
    @Override
    public User disconnect(int userId) throws Exception {
    	User user=userRepository2.findById(userId);
    	if(user.getConnected()==false)
    		throw new Exception("Already disconnected");
    	else
    		user.setConnected(Boolean.FALSE);
    	 
		return  userRepository2.save(user);

    }
    @Override
    public User communicate(int senderId, int receiverId) throws Exception {
    User sender= userRepository2.findById(senderId);
    User reciver=userRepository2.findById(receiverId);
    if(sender.getCountry().getCountryName().equals(reciver.getCountry().getCountryName()))
    {
    	return sender;
    }
    	
    else 
    	throw new Exception("Cannot establish communication");

    }
}
