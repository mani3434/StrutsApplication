package com.fund.actions;

import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {

	private String greeting;

	@Override
	@org.apache.struts2.convention.annotation.Action(value = "hi", results = {
			@Result(name = "success", location = "enter-protein", type = "redirect") })
	public String execute() throws Exception {

		setGreeting("Hello Sturts 2");

		return "success";
		// return "do-more";
	}

	/*
	 * @org.apache.struts2.convention.annotation.Action("hi-do-more") public String
	 * doMore() throws Exception {
	 * 
	 * setGreeting("Did more");
	 * 
	 * return "hello"; }
	 */

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
