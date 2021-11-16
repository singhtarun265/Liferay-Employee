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

package com.liferay.training.employee.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.training.employee.service.EmployeeServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>EmployeeServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeServiceSoap
 * @generated
 */
public class EmployeeServiceHttp {

	public static com.liferay.training.employee.model.Employee addEmployee(
			HttpPrincipal httpPrincipal, long userId, String name,
			String jobTitle, String phoneNo, float salary, long deptId,
			long projectId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "addEmployee",
				_addEmployeeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, name, jobTitle, phoneNo, salary, deptId,
				projectId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.employee.model.Employee)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.employee.model.Employee updateEmployee(
			HttpPrincipal httpPrincipal, long userId, long empId, String name,
			String jobTitle, String phoneNo, float salary, long deptId,
			long projectId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "updateEmployee",
				_updateEmployeeParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, empId, name, jobTitle, phoneNo, salary,
				deptId, projectId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.employee.model.Employee)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.employee.model.Employee deleteEmployee(
			HttpPrincipal httpPrincipal, long empId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "deleteEmployee",
				_deleteEmployeeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, empId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.employee.model.Employee)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.employee.model.Employee getEmployee(
			HttpPrincipal httpPrincipal, long empId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getEmployee",
				_getEmployeeParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, empId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.employee.model.Employee)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getEmployeesCount(
		HttpPrincipal httpPrincipal, String name, float salary) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getEmployeesCount",
				_getEmployeesCountParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, name, salary);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.training.employee.model.Employee>
		getEmployees(HttpPrincipal httpPrincipal, long deptId, float salary) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getEmployees",
				_getEmployeesParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, deptId, salary);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.training.employee.model.Employee>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.training.employee.model.Employee>
		getEmployeeByGroupIdAndUserIdAsRemote(
			HttpPrincipal httpPrincipal, long userId, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class,
				"getEmployeeByGroupIdAndUserIdAsRemote",
				_getEmployeeByGroupIdAndUserIdAsRemoteParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.training.employee.model.Employee>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.training.employee.model.Employee>
		getEmployeeByUserNameAndJobTitleAsRemote(
			HttpPrincipal httpPrincipal, String userName, String jobTitle) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class,
				"getEmployeeByUserNameAndJobTitleAsRemote",
				_getEmployeeByUserNameAndJobTitleAsRemoteParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userName, jobTitle);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.training.employee.model.Employee>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.training.employee.model.Employee>
		getAllEmployeesInformation(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getAllEmployeesInformation",
				_getAllEmployeesInformationParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.training.employee.model.Employee>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EmployeeServiceHttp.class);

	private static final Class<?>[] _addEmployeeParameterTypes0 = new Class[] {
		long.class, String.class, String.class, String.class, float.class,
		long.class, long.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateEmployeeParameterTypes1 =
		new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			float.class, long.class, long.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteEmployeeParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getEmployeeParameterTypes3 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getEmployeesCountParameterTypes4 =
		new Class[] {String.class, float.class};
	private static final Class<?>[] _getEmployeesParameterTypes5 = new Class[] {
		long.class, float.class
	};
	private static final Class<?>[]
		_getEmployeeByGroupIdAndUserIdAsRemoteParameterTypes6 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[]
		_getEmployeeByUserNameAndJobTitleAsRemoteParameterTypes7 = new Class[] {
			String.class, String.class
		};
	private static final Class<?>[] _getAllEmployeesInformationParameterTypes8 =
		new Class[] {};

}