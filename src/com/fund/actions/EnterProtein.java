package com.fund.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

//public class EnterProtein implements Action
@SuppressWarnings("serial")
public class EnterProtein extends ActionSupport implements SessionAware {

	/*
	 * @Override public void validate() {
	 * 
	 * if (!postBack) { return; }
	 * 
	 * if (enteredProtein <= 0) { addFieldError("enteredProtein",
	 * "value must be greater than zero"); }
	 * 
	 * }
	 */

	private int enteredProtein;
	private ProteinData proteinData;
	private Map<String, Object> session;
	private List<Integer> entries;
	private boolean postBack = false;
	private List<Integer> selections = new ArrayList<>();

	@Override
	@Action("enter-protein-input")
	public String input() throws Exception {

		if (session.containsKey("proteinData")) {
			proteinData = (ProteinData) session.get("proteinData");
		} else {
			proteinData = new ProteinData();
			proteinData.setTotal(0);
			proteinData.setGoal(300);
		}

		session.put("proteinData", proteinData);
		return "enter-protein";
	}

	@Override
	@Action("enter-protein")
	public String execute() throws Exception {

		if (session.containsKey("proteinData")) {
			proteinData = (ProteinData) session.get("proteinData");
		}

		if (proteinData != null) {
			ProtienTrackingService protienTrackingService = new ProtienTrackingService(proteinData);
			protienTrackingService.addProtein(enteredProtein);

		} else {
			proteinData = new ProteinData();
			proteinData.setTotal(0);
			proteinData.setGoal(300);
		}

		session.put("proteinData", proteinData);

		if (postBack) {
			return "ajax";
		}
		return SUCCESS;
	}

	public int getEnteredProtein() {
		return enteredProtein;
	}

	@IntRangeFieldValidator(type = ValidatorType.FIELD, min = "1", message = "entered protein must be greater than zero")
	public void setEnteredProtein(int enteredProtein) {
		this.enteredProtein = enteredProtein;
	}

	public String getGoalText() {
		return getText("goal.text");
	}

	public ProteinData getProteinData() {
		return proteinData;
	}

	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}

	@Override
	public void setSession(Map<String, Object> session) {

		this.session = session;
	}

	public void resetTotal() {

		proteinData.setTotal(0);
	}

	public List<Integer> getEntries() {

		entries = new ArrayList<Integer>();
		entries.add(25);
		entries.add(24);
		entries.add(87);
		entries.add(64);

		return entries;
	}

	public void setEntries(List<Integer> entries) {
		this.entries = entries;
	}

	public boolean isPostBack() {
		return postBack;
	}

	public void setPostBack(boolean postBack) {
		this.postBack = postBack;
	}

	public List<Integer> getSelections() {

		selections.clear();
		selections.add(1);
		selections.add(10);
		selections.add(100);
		selections.add(1000);
		selections.add(5);
		selections.add(55);
		selections.add(520);
		return selections;
	}

	public void setSelections(List<Integer> selections) {
		this.selections = selections;
	}

}
