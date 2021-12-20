<%@include file="/init.jsp"%>
<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

EmployeeModel entry = (EmployeeModel)row.getObject(); 
%>

<liferay-ui:icon-menu>

        <%-- <portlet:renderURL var="editURL">
            <portlet:param name="empId" value="<%= String.valueOf(entry.getEmpId()) %>" />
            <portlet:param name="mvcRenderCommandName" value="/editEntry" />
        </portlet:renderURL>

        <liferay-ui:icon image="edit" message="Edit"
            url="<%=editURL.toString() %>" />
 --%>
        <portlet:actionURL name="/deleteEntry" var="deleteURL">
            <portlet:param name="empId" value="<%= String.valueOf(entry.getEmpId()) %>" />
            <portlet:param name="deleteRow"  value="delete" />
        </portlet:actionURL>


        <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

</liferay-ui:icon-menu>