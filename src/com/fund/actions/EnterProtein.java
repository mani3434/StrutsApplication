package com.fund.actions;

import com.opensymphony.xwork2.ActionSupport;

//public class EnterProtein implements Action
public class EnterProtein extends ActionSupport {

	private int enteredProtein;

	@Override
	public String execute() throws Exception {

		ProtienTrackingService protienTrackingService = new ProtienTrackingService();
		protienTrackingService.addProtein(enteredProtein);

		return SUCCESS;
	}

	public int getEnteredProtein() {
		return enteredProtein;
	}

	public void setEnteredProtein(int enteredProtein) {
		this.enteredProtein = enteredProtein;
	}

	public String getGoalText() {
		return getText("goal.text");
	}

}
