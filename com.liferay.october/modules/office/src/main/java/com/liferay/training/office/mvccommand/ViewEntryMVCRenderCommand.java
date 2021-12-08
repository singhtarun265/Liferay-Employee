package com.liferay.training.office.mvccommand;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.training.employee.model.Employee;
import com.liferay.training.office.api.OfficeApi;
import com.liferay.training.office.constants.OfficePortletKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + OfficePortletKeys.OFFICE,
	       "mvc.command.name=/viewEntry"
	    },
	    service = MVCRenderCommand.class
	)
public class ViewEntryMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest request, RenderResponse response) throws PortletException {
		List<Employee> employeeList=officeApi.getAllEmployeesInformationOffice();
		request.setAttribute("employeeList",employeeList );
		
		System.out.println("Employee List"+employeeList);
		 SessionMessages.add(request,"employee-form-success");
		 
		
		 System.out.println("Just before");
	//	response.setRenderParameter("mvcPath", "/viewEmployee.jsp");
		
		return "/viewEmployee.jsp";
	}

	@Reference
	OfficeApi officeApi;
}
