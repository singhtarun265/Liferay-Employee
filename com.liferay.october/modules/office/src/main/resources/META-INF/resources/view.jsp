<%@ include file="/init.jsp"%>
<liferay-ui:success key="employeeAdded" message="successfully" />
<liferay-ui:error key="error-key" message="error" />
<liferay-ui:success key="remove" message="deletesuccessfully" />
<liferay-ui:error key="delete-key" message="deleteerror" />

<portlet:renderURL var="addEntryURL">
	<portlet:param name="mvcPath" value="/newEmployee.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="deleteEntryURL">
	<portlet:param name="mvcPath" value="/deleteEmployee.jsp"></portlet:param>
</portlet:renderURL>

<!-- <portlet:actionURL name="viewEntry" var="viewEntryURL">
	<portlet:param name="redirect" value="/viewEmployee.jsp" />
</portlet:actionURL> -->

<portlet:renderURL var="viewEntryURL">
    <portlet:param name="mvcRenderCommandName" value="/viewEntry" />
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%= addEntryURL.toString()%>" value="Registration"></aui:button>
	<aui:button onClick="<%= deleteEntryURL.toString()%>" value="Delete"></aui:button>
	<aui:button onClick="<%= viewEntryURL.toString()%>"
		value="View All Employees"></aui:button>
</aui:button-row>