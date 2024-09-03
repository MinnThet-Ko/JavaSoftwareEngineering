package com.hm.assignment5.dao;

import com.hm.assignment5.models.RentalContract;

public class RentalContractDAO {

	private RentalContract[] RentalContractList = new RentalContract[RentalContract.MAX_CONTRACTS];

	public void insertRentalContract(RentalContract rentalContract) {
		this.RentalContractList[RentalContract.getContractCount()-1] = rentalContract;
	}

	public RentalContract getContractByID(String id) {
		for (int i = 0; i < RentalContract.getContractCount(); i++) {
			if (this.RentalContractList[i].getId().equals(id)) {
				return this.RentalContractList[i];
			}
		}

		return null;
	}
	
	public void removeRentalContract(String id) {
		for (int i = 0; i < RentalContract.getContractCount(); i++) {
			if (this.RentalContractList[i].getId().equals(id)) {
				this.RentalContractList[i] = null;
			}
		}
	}
	
	public void updateRentalContract(RentalContract RentalContract) {
		for (int i = 0; i < RentalContract.getContractCount(); i++) {
			if (this.RentalContractList[i].getId().equals(RentalContract.getId())) {
				this.RentalContractList[i] = RentalContract;
			}
		}
	}
}
