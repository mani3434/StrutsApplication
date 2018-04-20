<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@  taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<sx:head />
<sj:head />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Protein Page</title>
</head>
<body>

	<h1>Enter Protein</h1>

	<s:form id="form1" action="enter-protein" validate="true">
		<s:hidden name="postBack" value="true"></s:hidden>
		<sx:autocompleter size="1" name="enteredProtein" list="selections"
			autoComplete="true"></sx:autocompleter>

		<%-- <s:textfield name="enteredProtein" /> --%>
		<sj:submit 
		formIds="form1" 
		targets="result"
		 value="Enter" 
		 button="true"></sj:submit>
		<%-- <s:submit value="Enter" /> --%>
	</s:form>

	Last entered values:
	<br />
	<s:select label="History" list="entries" />

	<%-- <s:iterator value="entries"> 
		*<s:property/>*<br/>
</s:iterator> --%>

	<%-- 	<s:generator separator="," val="%{'15,20,30'}">
		Last entered values: <br/>
		<s:iterator>
			*<s:property/>*<br/>
		</s:iterator>
	</s:generator> --%>


	<div id="result">

		<div>
			Last amount entered:
			<s:property value="enteredProtein" />
		</div>


		<div>
			Total for the day:
			<s:property value="proteinData.total" />
			grams
		</div>

	</div>
	<div>
		<s:text name="goal.text"></s:text>
		<%-- <s:property value="goalText" /> --%>
		<s:property value="proteinData.goal" />
	</div>

	<s:if test="%{proteinData.total >= proteinData.goal}">

		<s:property value="resetTotal()" />

	</s:if>

	<a href="<s:url action="enter-goal"/>"> Edit Goal</a>



</body>
</html>