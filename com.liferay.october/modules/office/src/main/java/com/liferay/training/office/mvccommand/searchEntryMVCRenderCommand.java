package com.liferay.training.office.mvccommand;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.employee.model.Employee;
import com.liferay.training.office.api.OfficeApi;
import com.liferay.training.office.constants.OfficePortletKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + OfficePortletKeys.OFFICE,
	       "mvc.command.name=/searchContainers"
	    },
	    service = MVCRenderCommand.class
	)
public class SearchEntryMVCRenderCommand implements MVCRenderCommand {
	
	private static Log log = LogFactoryUtil.getLog(SearchEntryMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		PortletURL iteratorURL=PortletURLFactoryUtil.create(renderRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		iteratorURL.setParameter("mvcRenderCommandName", "/searchContainers");
		
		SearchContainer<Employee> searchContainer = null;
		
		
		searchContainer = new SearchContainer<>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, iteratorURL, null, "");
		searchContainer.setEmptyResultsMessage("There are no records to display");
		searchContainer.setDelta(5);
		searchContainer.setDeltaConfigurable(true);
		
		
		List<Employee> employeeList=officeApi.getAllEmployeesInformationOffice(searchContainer.getStart(),searchContainer.getEnd());
		
//		List<Employee> employeeList=officeApi.getAllEmployeesInformationOffice(0,5);
		
		int count= employeeList.size();
		
		searchContainer.setResults(employeeList);
		searchContainer.setTotal(20);
		
		renderRequest.setAttribute("searchContainer", searchContainer);
			
		
//		renderRequest.setAttribute("employeeList",employeeList );
//		renderRequest.setAttribute("count",count );
		
		 SessionMessages.add(renderRequest,"employee-form-success");
		 log.info("Added employeelist and count attribute to search container"); 
		
		//System.out.println("Hello search container");
	//	response.setRenderParameter("mvcPath", "/viewEmployee.jsp");
		
		// renderRequest.setAttribute("jspPath", "/searchContainer.jsp");
		return "/searchContainer.jsp";
	}

	@Reference
	OfficeApi officeApi;
}
