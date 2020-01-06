package com.deloitte.ecommerce.entities;

public class Wallet {
	private String mobileno;
	private String name;
	private double balance;
	private String password;
	
	public Wallet() {}
	
	public Wallet(String mobileno, String password, String name, double balance) {
		this.mobileno=mobileno;
		this.password=password;
		this.name=name;
		this.balance=balance;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}
	
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void addAmount(double amount) {
		balance=balance+amount;
	}
	
	
	 @Override
	 public boolean equals(Object obj) {
		 if(obj==this) {
			 return true;
		 }
		 
		 if(obj==null || !(obj instanceof Wallet)) {
			 return false;
		 }
		 
		 Wallet w=(Wallet)obj;
	     return w.mobileno.equals(this.mobileno);
		 
	 }
	 
	 @Override
	    public int hashCode() {
	     return mobileno.hashCode();
	    }

}
