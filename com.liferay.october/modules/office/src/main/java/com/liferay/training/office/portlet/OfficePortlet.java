package com.liferay.training.office.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.employee.model.Employee;
import com.liferay.training.office.api.OfficeApi;
import com.liferay.training.office.constants.OfficePortletKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Argil DX
 */
@Component(immediate = true, property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Office", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", 
		"javax.portlet.name=" + OfficePortletKeys.OFFICE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OfficePortlet extends MVCPortlet {

	public void addEntry(ActionRequest request, ActionResponse response) throws PortalException, SystemException {

		// ThemeDisplay themeDisplay = (ThemeDisplay)
		// request.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Employee.class.getName(), request);

		// long groupId = themeDisplay.getScopeGroupId();

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

		} catch (Exception e) {
			SessionErrors.add(request, "error-key");
			System.out.println("The error " + e);
			System.err.println(e);

		}
	}

	public void deleteEntry(ActionRequest request, ActionResponse response) throws PortalException, SystemException {

		// ThemeDisplay themeDisplay = (ThemeDisplay)
		// request.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Employee.class.getName(), request);

		// long groupId = themeDisplay.getScopeGroupId();

		long empId = ParamUtil.getLong(request, "empId");

		try {
			officeApi.deleteEmployeeOffice(empId);
			System.out.println("Data is deleted");
			SessionMessages.add(request, "remove");

		} catch (Exception e) {
			SessionErrors.add(request, "delete-key");
			System.out.println("The error " + e);
			System.err.println(e);

		}
	}

	public List<Employee> viewEntry()
			throws PortalException, SystemException {

		try {

//    	System.out.println("Data is deleted");
//    	SessionMessages.add(request, "remove");
//    	
			return officeApi.getAllEmployeesInformationOffice();

		} catch (Exception e) {
			//SessionErrors.add(request, "delete-key");
			System.out.println("The error " + e);
			System.err.println(e);

		}

		return null;

	}

	@Reference
	OfficeApi officeApi;
}