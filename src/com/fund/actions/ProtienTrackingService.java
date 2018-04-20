package com.fund.actions;

public class ProtienTrackingService {

	private ProteinData proteinData;

	public ProtienTrackingService(ProteinData proteinData) {
		this.proteinData = proteinData;
	}

	public void addProtein(int enteredProtein) {

		proteinData.setTotal(proteinData.getTotal() + enteredProtein);

	}

}
