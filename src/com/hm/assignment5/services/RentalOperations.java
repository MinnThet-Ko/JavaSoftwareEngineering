package com.hm.assignment5.services;


//Also, make a util class for to check whether the object in question exists or not.
public interface RentalOperations {
	
	public void getProcessType();
	public void performRegister();
	public void performUpdate();
	public void performRetrieve();
	public void performDelete();
	public Object retrieveById();

}
