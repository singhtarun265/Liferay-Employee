package com.liferay.training.office.api;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.employee.model.Employee;

import java.util.List;

/**
 * @author Argil DX
 */
public interface OfficeApi {
	
	public Employee addEmployeeOffice(long userId, String name, String jobTitle, String phoneNo, long salary, long deptId,
			long projectId, ServiceContext serviceContext) throws PortalException;

	public Employee updateEmployeeOffice(long userId, long empId, String name, String jobTitle, String phoneNo, long salary,
			long deptId, long projectId, ServiceContext serviceContext) throws PortalException;
	
	public Employee deleteEmployeeOffice(long empId) throws PortalException ;

	public Employee getEmployeeOffice(long empId) throws PortalException ;

	public List<Employee> getEmployeesOffice(long deptId, long salary) ;

	public List<Employee> getEmployeesOffice(long deptId, long salary, int start, int end);

	public List<Employee> getEmployeesOffice(long deptId, long salary, int start, int end, OrderByComparator<Employee> obc);

	public int getEmployeesCountOffice(String name, long salary) ;

	public List<Employee> getEmployeeByGroupIdAndUserIdOffice(long userId, long groupId) ;

	public List<Employee> getEmployeeByUserNameAndJobTitleOffice(String userName, String jobTitle);
	
	public List<Employee> getAllEmployeesInformationOffice(int start, int end) ;
	
	public int getEmployeesCountOffice();
}