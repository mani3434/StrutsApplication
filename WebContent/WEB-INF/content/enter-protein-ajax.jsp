
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@  taglib prefix="s" uri="/struts-tags"%>

<div>
	Last amount entered:
	<s:property value="enteredProtein" />
</div>


<div>
	Total for the day:
	<s:property value="proteinData.total" />
	grams
</div>

