<%@ include file="init.jsp"%>


<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="viewEntryURL">
    <portlet:param name="mvcRenderCommandName" value="/viewEntry" />
</portlet:renderURL>
<portlet:actionURL name="/deleteEntry" var="deleteEntryURL"/>


<liferay-ui:success key="remove" message="deletesuccessfully" />
<liferay-ui:error key="delete-key" message="deleteerror"/>
<aui:form action="<%=deleteEntryURL%>" name="<portlet:namespace />fm">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Basic Info">
			<aui:row>
				<aui:col width="50">
					<aui:input label="Enter the Employee ID" name="empId" type="text">
						<aui:validator errorMessage="Please enter the Employee ID"
							name="required"></aui:validator>
							<aui:validator name="number"></aui:validator>
					</aui:input>
				</aui:col>
				
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>


	<aui:button-row>
		<aui:button type="submit" value="Delete"></aui:button>
		<aui:button type="cancel" onClick="<%=viewURL.toString()%>"></aui:button>
		<aui:button onClick="<%= viewEntryURL.toString()%>"	value="View All Employees"></aui:button>
	</aui:button-row>
</aui:form>