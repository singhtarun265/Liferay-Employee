package com.liferay.training.office;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.employee.model.Employee;
import com.liferay.training.employee.service.EmployeeLocalService;
import com.liferay.training.office.api.OfficeApi;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Argil DX
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	}
	//service = OfficeApi.class
)
public class OfficeService implements OfficeApi {

	@Override
	public Employee addEmployeeOffice(long userId, String name, String jobTitle, String phoneNo, float salary,
			long deptId, long projectId, ServiceContext serviceContext) throws PortalException {
		
		return employeeLocalService.addEmployee(userId, name, jobTitle, phoneNo, salary, deptId, projectId, serviceContext);
	}

	@Override
	public Employee updateEmployeeOffice(long userId, long empId, String name, String jobTitle, String phoneNo,
			float salary, long deptId, long projectId, ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		return employeeLocalService.updateEmployee(userId, empId, name, jobTitle, phoneNo, salary, deptId, projectId, serviceContext);
	}

	
	@Override
	public Employee deleteEmployeeOffice(long empId) throws PortalException {
		// TODO Auto-generated method stub
		return employeeLocalService.deleteEmployee(empId);
	}

	@Override
	public Employee getEmployeeOffice(long empId) throws PortalException {
		// TODO Auto-generated method stub
		return employeeLocalService.getEmployee(empId);
	}

	@Override
	public List<Employee> getEmployeesOffice(long deptId, float salary) {
		// TODO Auto-generated method stub
		return employeeLocalService.getEmployees(deptId, salary);
	}

	@Override
	public List<Employee> getEmployeesOffice(long deptId, float salary, int start, int end) {
		// TODO Auto-generated method stub
		return employeeLocalService.getEmployees(deptId, salary, start, end);
	}

	@Override
	public List<Employee> getEmployeesOffice(long deptId, float salary, int start, int end,
			OrderByComparator<Employee> obc) {
		// TODO Auto-generated method stub
		return employeeLocalService.getEmployees(deptId, salary, start, end, obc);
	}

	@Override
	public int getEmployeesCountOffice(String name, float salary) {
		// TODO Auto-generated method stub
		return employeeLocalService.getEmployeesCount(name, salary);
	}

	@Override
	public List<Employee> getEmployeeByGroupIdAndUserIdOffice(long userId, long groupId) {
		// TODO Auto-generated method stub
		return employeeLocalService.getEmployeeByGroupIdAndUserIdAsLocal(userId, groupId);
	}

	@Override
	public List<Employee> getEmployeeByUserNameAndJobTitleOffice(String userName, String jobTitle) {
		// TODO Auto-generated method stub
		return employeeLocalService.getEmployeeByUserNameAndJobTitleAsLocal(userName, jobTitle);
	}
	
	@Override
	public List<Employee> getAllEmployeesInformationOffice(int start, int end) {
		// TODO Auto-generated method stub
		return employeeLocalService.getAllEmployeesInformationAsLocal(start,end);
	}
	

	@Reference
	EmployeeLocalService employeeLocalService;



	
}
