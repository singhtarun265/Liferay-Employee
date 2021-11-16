<%@ include file="init.jsp"%>
<%@page import="com.liferay.training.employee.model.Employee"%>
<%@page import="com.liferay.training.office.portlet.OfficePortlet"%>
<%@page import="java.util.List"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="viewEntry" var="viewEntryURL"></portlet:actionURL>


<%
Employee employee=null;
OfficePortlet officePortlet= new  OfficePortlet();
List list=officePortlet.viewEntry();
%>

<table border="1" width="500">
<tr>
        <th>uuid_ </th>
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
 <%for(Object object:list){
       Object[] arrayobject=(Object[])object;
       employee=(Employee)arrayobject[0];
  %>
       <tr>
       <td><%=employee.getUuid()%></td>
       
       <td><%=employee.getGroupId()%></td>
       <td><%=employee.getCompanyId()%></td>
       <td><%=employee.getName()%></td>
       <td><%=employee.getUserName()%></td>
       <td><%=employee.getUserId()%></td>
       
       <td><%=employee.getPhoneNo()%></td>
       <td><%=employee.getSalary()%></td>
       <td><%=employee.getDeptId()%></td>
       <td><%=employee.getProjectId()%></td>
       <td><%=employee.getCreateDate()%></td>
       <td><%=employee.getModifiedDate()%></td>
       </tr>
      
<%} %>
</table>