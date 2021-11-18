<%@include file="init.jsp"%>
<%@page import="com.liferay.training.employee.model.Employee"%>
<%@page import="com.liferay.training.office.portlet.OfficePortlet"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<div class="container">
	<!-- <table border="1" width="500"> -->
	<table class="table table-condensed">
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
		<%List<Employee> employeeList=(List<Employee>)renderRequest.getAttribute("employeeList");
			if(employeeList!=null){
	
				for(Employee employee:employeeList){
%>
		<tr>
			<td><%=employee.getUuid()%></td>
			<td><%=employee.getEmpId()%></td>
			<td><%=employee.getGroupId()%></td>
			<td><%=employee.getCompanyId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getUserName()%></td>
			<td><%=employee.getUserId()%></td>
			<td><%=employee.getJobTitle()%></td>
			<td><%=employee.getPhoneNo()%></td>
			<td><%=employee.getSalary()%></td>
			<td><%=employee.getDeptId()%></td>
			<td><%=employee.getProjectId()%></td>
			<td><%=employee.getCreateDate()%></td>
			<td><%=employee.getModifiedDate()%></td>
		</tr>

				<%} }%>
	</table>
	<aui:button type="cancel" onClick="<%=viewURL.toString()%>"></aui:button>
</div>