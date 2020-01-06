package com.deloitte.ecommerce.dao;

import com.deloitte.ecommerce.entities.*;

import java.util.*;

public interface IWalletDao {
	
	
	
	Wallet findByMobileno(String mobileno);
	
	
	
	public boolean credentialsCorrect(String mobileno, String password);

}
