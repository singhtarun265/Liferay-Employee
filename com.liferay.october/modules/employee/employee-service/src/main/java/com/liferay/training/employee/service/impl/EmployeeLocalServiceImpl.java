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

package com.liferay.training.employee.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.employee.model.Employee;
import com.liferay.training.employee.service.base.EmployeeLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.training.employee.service.EmployeeLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.liferay.training.employee.model.Employee", service = AopService.class)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.liferay.training.employee.service.EmployeeLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.liferay.training.employee.service.EmployeeLocalServiceUtil</code>.
	 */

	public Employee addEmployee(long userId, String name, String jobTitle, String phoneNo, float salary, long deptId,
			long projectId, ServiceContext serviceContext) throws PortalException {
		
	//ThemeDisplay themeDisplay = (ThemeDisplay) serviceContext.getAttribute(WebKeys.THEME_DISPLAY);
		
	//	long groupId = themeDisplay.getScopeGroupId();
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userLocalService.getUserById(userId);

		long empId = counterLocalService.increment();

		Employee employee = employeePersistence.create(empId);

		employee.setUuid(serviceContext.getUuid());
		employee.setUserId(userId);
		employee.setGroupId(groupId);
		employee.setCompanyId(user.getCompanyId());
		employee.setUserName(user.getFullName());
		employee.setCreateDate(serviceContext.getCreateDate());
		employee.setModifiedDate(serviceContext.getModifiedDate());
		employee.setExpandoBridgeAttributes(serviceContext);
		employee.setEmpId(empId);
		employee.setName(name);
		employee.setJobTitle(jobTitle);
		employee.setPhoneNo(phoneNo);
		employee.setSalary(salary);
		employee.setDeptId(deptId);
		employee.setProjectId(projectId);

		employeePersistence.update(employee);
		
		return employee;

	}

	public Employee updateEmployee(long userId, long empId, String name, String jobTitle, String phoneNo, float salary,
			long deptId, long projectId, ServiceContext serviceContext) throws PortalException {

		Employee employee = employeePersistence.findByPrimaryKey(empId);

		User user = userLocalService.getUserById(userId);

		employee.setUserId(userId);
		employee.setUserName(user.getFullName());
		employee.setModifiedDate(serviceContext.getModifiedDate());
		employee.setExpandoBridgeAttributes(serviceContext);
		employee.setEmpId(empId);
		employee.setName(name);
		employee.setJobTitle(jobTitle);
		employee.setPhoneNo(phoneNo);
		employee.setSalary(salary);
		employee.setDeptId(deptId);
		employee.setProjectId(projectId);
		employeePersistence.update(employee);

		return employee;
	}

	public Employee deleteEmployee(Employee employee) throws PortalException {

		employeePersistence.remove(employee);

		return employee;
	}

	public Employee deleteEmployee(long empId) throws PortalException {

		Employee employee = employeePersistence.findByPrimaryKey(empId);

		return deleteEmployee(employee);

	}

	public Employee getEmployee(long empId) throws PortalException {

		return employeePersistence.findByPrimaryKey(empId);
	}

	public List<Employee> getEmployees(long deptId, float salary) {

		return employeePersistence.findBydeptSalary(deptId, salary);
	}

	public List<Employee> getEmployees(long deptId, float salary, int start, int end) {

		return employeePersistence.findBydeptSalary(deptId, salary, start, end);
	}

	public List<Employee> getEmployees(long deptId, float salary, int start, int end, OrderByComparator<Employee> obc) {

		return employeePersistence.findBydeptSalary(deptId, salary, start, end, obc);
	}

	public int getEmployeesCount(String name, float salary) {

		return employeePersistence.countBynameSalary(name, salary);
	}

	public List<Employee> getEmployeeByGroupIdAndUserIdAsLocal(long userId, long groupId) {
		return employeeFinder.getEmployeeByGroupIdAndUserId(userId, groupId);

	}

	public List<Employee> getEmployeeByUserNameAndJobTitleAsLocal(String userName, String jobTitle) {

		
		/*
		 * List<Employee> employeeList =
		 * dynamicQuery(employeeLocalService.dynamicQuery().
		 * add(RestrictionsFactoryUtil.eq("name", userName)).
		 * add(RestrictionsFactoryUtil.eq("jobTitle", jobTitle)));
		 * 
		 *  return employeeList;
		 */ 
		
		return employeeFinder.getEmployeeByUserNameAndJobTitleWithDynamic(userName, jobTitle);
		 
	}
	public List<Employee> getAllEmployeesInformationAsLocal(int start, int end) {
		return employeeFinder.getAllEmployeesInformation(start,end);
	}
	

}