<%@include file="init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="java.util.List"%>


<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

 <link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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

	</table>
	<aui:button type="cancel" onClick="<%=viewURL.toString()%>"></aui:button>
</div>