package com.liferay.training.office.mvccommand;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.office.api.OfficeApi;
import com.liferay.training.office.constants.OfficePortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + OfficePortletKeys.OFFICE,
	       "mvc.command.name=/deleteEntry"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteEntryMVCActionCommand  extends BaseMVCActionCommand {

	

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		
	System.out.println("Hello Delete");
		long empId = Long.parseLong(request.getParameter("empId").toString());
		String deleteRow =request.getParameter("deleteRow").toString();
		try {
			//officeApi.deleteEmployeeOffice(empId);
			System.out.println("Data is deleted");
			SessionMessages.add(request, "remove");
			
		//response.setRenderParameter("mvcPath", "/deleteEmployee.jsp");
			
			/*if(deleteRow.isEmpty())
		request.setAttribute("jspPath", "/deleteEmployee.jsp");
			else*/
		request.setAttribute("mvcRenderCommandName", "/searchContainers");		
				
		} catch (Exception e) {
			SessionErrors.add(request, "delete-key");
			System.out.println("The error " + e);
			System.err.println(e);

		}
		
	}

	@Reference
	OfficeApi officeApi;
	
	
}
