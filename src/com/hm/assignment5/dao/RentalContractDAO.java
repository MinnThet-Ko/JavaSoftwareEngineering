package com.hm.assignment5.dao;

import com.hm.assignment5.models.RentalContract;

public class RentalContractDAO {

	private static int contractCount = 0;
	private static final int MAX_CONTRACT = 1000;

	private RentalContract[] rentalContractList = new RentalContract[MAX_CONTRACT];

	public void insertRentalContract(RentalContract rentalContract) {
		this.rentalContractList[contractCount] = rentalContract;
	}

	public RentalContract getContractByID(String id) {
		for (int i = 0; i < contractCount; i++) {
			if (this.rentalContractList[i].getId().equals(id)) {
				return this.rentalContractList[i];
			}
		}

		return null;
	}

	public void removeRentalContract(String id) {
		for (int i = 0; i < contractCount; i++) {
			if (this.rentalContractList[i].getId().equals(id)) {
				this.rentalContractList[i] = null;
			}
		}
	}

	public void updateRentalContract(RentalContract RentalContract) {
		for (int i = 0; i < contractCount; i++) {
			if (this.rentalContractList[i].getId().equals(RentalContract.getId())) {
				this.rentalContractList[i] = RentalContract;
			}
		}
	}

	public static void increaseContractCount() {
		contractCount++;
	}

	public static void decreaseContractCount() {
		contractCount--;
	}

	public static int getContractCount() {
		return contractCount;
	}
}
