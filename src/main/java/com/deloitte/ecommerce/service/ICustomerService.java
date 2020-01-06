package com.deloitte.ecommerce.service;

import java.util.*;

import com.deloitte.ecommerce.entities.*;

public interface ICustomerService {
	
	
	Wallet findByMobileno(String mobileno);
	
	public boolean credentialsCorrect(String mobileno, String password);

}
