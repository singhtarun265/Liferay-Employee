package com.liferay.training.office.mvccommand;

import com.liferay.portal.kernel.exception.PortalException;
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
	       "mvc.command.name=/editEntry"
	    },
	    service = MVCRenderCommand.class
	)
public class EditEntryMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest request, RenderResponse response) throws PortletException {
		
		long empId = Long.parseLong(request.getAttribute("empId").toString());
		
		try {
			Employee employee = officeApi.getEmployeeOffice(empId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//request.setAttribute("employeeList",employeeList );
		
		SessionMessages.add(request,"employee-form-success");
		 
		
		 System.out.println("Just before");
	//	response.setRenderParameter("mvcPath", "/viewEmployee.jsp");
		
		return "/viewEmployee.jsp";
	}

	@Reference
	OfficeApi officeApi;
}
