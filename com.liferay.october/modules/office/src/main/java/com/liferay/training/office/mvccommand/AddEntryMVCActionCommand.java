package com.liferay.training.office.mvccommand;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.employee.model.Employee;
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
	        "mvc.command.name=/new/addEntry"
	    },
	    service = MVCActionCommand.class
	    )
public class AddEntryMVCActionCommand extends BaseMVCActionCommand {

	
	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		// TODO Auto-generated method stub
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Employee.class.getName(), request);

		String name = ParamUtil.getString(request, "name");
		String jobTitle = ParamUtil.getString(request, "jobTitle");

		long phoneNo = ParamUtil.getLong(request, "phoneNo");
		String phone = Long.toString(phoneNo);
		long salary = ParamUtil.getLong(request, "salary");
		long deptId = ParamUtil.getLong(request, "deptId");
		long projectId = ParamUtil.getLong(request, "projectId");
		long userId = ParamUtil.getLong(request, "userId");

		try {
			officeApi.addEmployeeOffice(userId, name, jobTitle, phone, salary, deptId, projectId, serviceContext);
			System.out.println("Data is inserted");
			SessionMessages.add(request, "employeeAdded");
			//response.setRenderParameter("mvcPath", "/newEmployee.jsp");

			request.setAttribute("jspPath", "/newEmployee.jsp");
			
		} catch (Exception e) {
			SessionErrors.add(request, "error-key");
			System.out.println("The error " + e);
			System.err.println(e);

		}
	}

	@Reference
	OfficeApi officeApi;

	

}
