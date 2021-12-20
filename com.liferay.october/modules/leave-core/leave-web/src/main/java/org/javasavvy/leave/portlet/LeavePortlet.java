package org.javasavvy.leave.portlet;

import org.javasavvy.leave.constants.LeavePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Argil DX
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Leave",
   	    "javax.portlet.init-param.view-action=/leave/view",
	    "javax.portlet.init-param.view-template=/leave/view.jsp",
		"javax.portlet.name=" + LeavePortletKeys.LEAVE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LeavePortlet extends MVCPortlet {
}