package com.deloitte.ecommerce.service;

import java.util.*;

import com.deloitte.ecommerce.entities.*;
import com.deloitte.ecommerce.exceptions.*;
import com.deloitte.ecommerce.dao.*;

public class CustomerServiceImpl implements ICustomerService {
	private IWalletDao dao;

	public CustomerServiceImpl(IWalletDao dao) {
		this.dao=dao;
	}
	
	
	@Override
    public boolean credentialsCorrect(String mobileno, String password) {
        boolean correct = dao.credentialsCorrect(mobileno, password);
        return correct;
    }
	
	@Override
	public Wallet findByMobileno(String mobileno) {
		if(mobileno!=null||mobileno.length()!=10) {
			throw new IncorrectMobNoException("Mobile number is incorrect");
		}
		
		Wallet w=dao.findByMobileno(mobileno);
		return w;
	}
	
	

}
