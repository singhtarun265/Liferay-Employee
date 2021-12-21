<%@include file="init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="java.util.List"%>
<%@page import="com.liferay.training.employee.model.Employee" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil" %>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<%-- 
<div class="container">
	<!-- <table border="1" width="500"> -->
	<table >
		<tr>
			<th>uuid_</th>
			<th>empId</th>
			<th>groupId</th>
			<th>companyId</th>
			<th>name</th>
			<th>userName</th>
			<th>userId</th>
			<th>jobTitle</th>
			<th>phoneNo</th>
			<th>salary</th>
			<th>deptId</th>
			<th>projectId</th>
			<th>createDate</th>
			<th>modifiedDate</th>
		</tr>
		
	<c:forEach items="${employeeList}" var="employee">  
  			<tr> 
    		<td>${employee.uuid}</td>
			<td>${employee.empId}</td>
			<td>${employee.groupId}</td>
			<td>${employee.companyId}</td>
			<td>${employee.name}</td>
			<td>${employee.userName}</td>
			<td>${employee.userId}</td>
			<td>${employee.jobTitle}</td>
			<td>${employee.phoneNo}</td>
			<td>${employee.salary}</td>
			<td>${employee.deptId}</td>
			<td>${employee.projectId}</td>
			<td>${employee.createDate}</td>
			<td>${employee.modifiedDate}</td>
		</tr>
        
</c:forEach> 

	</table> --%>
	
	<liferay-portlet:renderURL varImpl="iteratorURL">
			<portlet:param name="mvcPath" value="/searchContainer.jsp"/>	
	</liferay-portlet:renderURL>
	
	<%-- <liferay-ui:search-container delta="5" deltaConfigurable="true" total="${count}"
	emptyResultsMessage="There are no records to display" iteratorURL="<%= iteratorURL %>" >
	<liferay-ui:search-container-results 
	    results="<%= ListUtil.subList((List<Employee>)renderRequest.getAttribute("employeeList"),
	    		searchContainer.getStart(), searchContainer.getEnd()) %>"
	    /> --%>
	    
	    
    <liferay-ui:search-container searchContainer="${searchContainer}">
    <liferay-ui:search-container-results results="${searchContainer.results}" />
	<liferay-ui:search-container-row className="com.liferay.training.employee.model.EmployeeModel" keyProperty="empId" modelVar="aEmployeeModel">
	
	<liferay-ui:search-container-column-text property="empId" name="Employee ID" value="${aEmployeeModel.empId}" />
	<liferay-ui:search-container-column-text property="groupId" name="Group ID" value="${aEmployeeModel.groupId}" />
	<liferay-ui:search-container-column-text property="companyId" name="Company ID" value="${aEmployeeModel.companyId}" />
	<liferay-ui:search-container-column-text property="name" name="Name" value="${aEmployeeModel.name}" />
	<liferay-ui:search-container-column-text property="userName" name="Username" value="${aEmployeeModel.userName}" />
	<liferay-ui:search-container-column-text property="userId" name="User ID" value="${aEmployeeModel.userId}" />
	<liferay-ui:search-container-column-text property="jobTitle" name="Job Title" value="${aEmployeeModel.jobTitle}" />
	<liferay-ui:search-container-column-text property="phoneNo" name="Phone No" value="${aEmployeeModel.phoneNo}" />
	<liferay-ui:search-container-column-text property="salary" name="Salary" value="${aEmployeeModel.salary}" />
	<liferay-ui:search-container-column-text property="deptId" name="Department ID" value="${aEmployeeModel.deptId}" />
	<liferay-ui:search-container-column-text property="projectId" name="Project ID" value="${aEmployeeModel.projectId}" />
	<liferay-ui:search-container-column-text property="createDate" name="Create Date" value="${aEmployeeModel.createDate}" />
	<liferay-ui:search-container-column-text property="modifiedDate" name="Modified Date" value="${aEmployeeModel.modifiedDate}" />	
	<liferay-ui:search-container-column-jsp align="right"  name="Actions" path="/entry_actions.jsp" />
	 
	</liferay-ui:search-container-row>
	 <liferay-ui:search-iterator searchContainer="${searchContainer}" markupView="lexicon" />
	<%-- <liferay-ui:search-iterator searchContainer="<%=searchContainer %>"  /> --%>
	</liferay-ui:search-container>
	<aui:button type="cancel" onClick="<%=viewURL.toString()%>"></aui:button>
<!-- </div> -->