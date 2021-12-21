package com.liferay.training.office.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.office.constants.OfficePortletKeys;
import com.liferay.training.office.mvccommand.SearchEntryMVCRenderCommand;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
		"javax.portlet.security-role-ref=power-user,user" }, 
     service = Portlet.class)

public class OfficePortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(OfficePortlet.class);
/**	
	@throws IOException 
 * @Override
		public void render(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			// TODO Auto-generated method stub
		
			super.render(renderRequest, renderResponse);
		}

	public void addEntry(ActionRequest request, ActionResponse response) throws PortalException, SystemException {

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

		} catch (Exception e) {
			SessionErrors.add(request, "error-key");
			System.out.println("The error " + e);
			System.err.println(e);

		}
	}

	public void deleteEntry(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
 
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

	@SuppressWarnings("deprecation")
	public void viewEntry(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		try {

   	
			List<Employee> employeeList=officeApi.getAllEmployeesInformationOffice();
			request.setAttribute("employeeList",employeeList );
			
			System.out.println("Employee List"+employeeList);
			 SessionMessages.add(request,"employee-form-success");
			 
			
			 System.out.println("Just before");
			response.setRenderParameter("mvcPath", "/viewEmployee.jsp");
			
			
		} catch (Exception e) {
			//SessionErrors.add(request, "delete-key");
			 SessionErrors.add( request,"employee-form-error");
			 

		}

		
	}

	@Reference
	OfficeApi officeApi;
	**/
	//@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		try {
			
		/*
		 * String req= renderRequest.getParameter("mvcRenderCommandName");
		 * 
		 * if(req!=null) include(req+".jsp",renderRequest,renderResponse); else
		 * super.render(renderRequest, renderResponse);
		 */
		
		if (Validator.isNotNull(renderRequest.getAttribute("jspPath").toString()))
			include(renderRequest.getAttribute("jspPath").toString(), renderRequest, renderResponse);
			log.info("calling required JSP page");
		
		} catch (Exception e) {
				log.info("calling required JSP page defaut JSP page search container JSP");
				
				super.render(renderRequest, renderResponse);
				System.out.println("Render catch block");
				//log.error(e);
		} finally {
			System.out.println("Hello render");
			
		}
	}

	
	
}