/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.javasavvy.leave.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import java.util.Date;
import java.util.List;

import org.javasavvy.leave.model.Leave;
import org.javasavvy.leave.service.base.LeaveLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the leave local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>org.javasavvy.leave.service.LeaveLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=org.javasavvy.leave.model.Leave",
	service = AopService.class
)
public class LeaveLocalServiceImpl extends LeaveLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>org.javasavvy.leave.service.LeaveLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>org.javasavvy.leave.service.LeaveLocalServiceUtil</code>.
	 */
	
	public int getLeaveCount(long userId) {
		return leavePersistence.countByuserId(userId);
	}
	
	public Leave addLeave(String leaveName, long userId, long groupId, long companyId, Date startDate, Date leaveEndDate) {
		
	long leaveId=counterLocalService.increment(Leave.class.getName());
	
	Leave leave =null;
	try {
		
		User user= userLocalService.getUser(userId);
		leave=leaveLocalService.createLeave(leaveId);
		leave.setUserId(userId);
		leave.setCreateDate(new Date());
		leave.setLeaveName(leaveName);
		leave.setStartDate(startDate);
		leave.setEndDate(leaveEndDate);
		leave.setUserName(user.getFullName());
		leave.setCompanyId(companyId);
		leave.setGroupId(groupId);
		
		leave=leaveLocalService.addLeave(leave);
		
	}
	catch (PortalException e) {
		e.printStackTrace();
	}
		return leave;	
		
	}
	
	public List<Leave> getLeaveByUserId(long userId){
		return leavePersistence.findByuserId(userId);
	}
	public List<Leave> getLeaveByUserId(long userId, int start, int end){
		return leavePersistence.findByuserId(userId,start,end);
	}
}