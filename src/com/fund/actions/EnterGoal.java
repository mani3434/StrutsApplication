package com.fund.actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class EnterGoal extends ActionSupport implements SessionAware {

	private int goal;
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {

		ProteinData proteinData;

		if (session.containsKey("proteinData")) {
			proteinData = (ProteinData) session.get("proteinData");
		} else {
			proteinData = new ProteinData();
		}

		goal = proteinData.getGoal();

		return SUCCESS;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	@Action(value = "enter-goal-save")
	public String save() throws Exception {

		ProteinData proteinData;

		if (session.containsKey("proteinData")) {
			proteinData = (ProteinData) session.get("proteinData");
		} else {
			proteinData = new ProteinData();
		}

		proteinData.setGoal(goal);

		session.put("proteinData", proteinData);

		return "enter-goal";
	}

}
