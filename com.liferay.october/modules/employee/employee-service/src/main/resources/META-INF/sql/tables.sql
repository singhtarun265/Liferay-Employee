create table Employee_Department (
	deptId LONG not null primary key,
	deptName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Employee_Employee (
	uuid_ VARCHAR(75) null,
	empId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	jobTitle VARCHAR(75) null,
	phoneNo VARCHAR(75) null,
	salary DOUBLE,
	deptId LONG,
	projectId LONG
);

create table Employee_Project (
	projectId LONG not null primary key,
	projectName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);