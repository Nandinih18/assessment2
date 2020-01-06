package com.deloitte.ecommerce.dao;

import com.deloitte.ecommerce.entities.*;
import com.deloitte.ecommerce.exceptions.*;


import java.util.*;

public class WalletDaoImpl implements IWalletDao {
	private Map<String, Wallet> store = new HashMap<>();
	
	public WalletDaoImpl() {
		Wallet user1=new Wallet("1234567890","1234","Nandini",1000);
		store.put("1234567890",user1);
		Wallet user2=new Wallet("9087654321","9999","Nida",2000);
		store.put("9087654321",user2);
	}

	
	@Override
	public Wallet findByMobileno(String mobileno) {
		Wallet w = store.get(mobileno);
		if (w == null) {
			throw new CustomerNotFoundException("customer not found for mobile number:" + mobileno);
		}
		return w;
	}

	

	  @Override
	    public boolean credentialsCorrect(String mobileno, String password) {
	        Wallet user = store.get(mobileno);
	        if (user == null) {
	            return false;
	        }
	        return user.getPassword().equals(password);
	    }

	}


