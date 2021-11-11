create index IX_52879397 on Employee_Employee (deptId, salary);
create index IX_18E23D25 on Employee_Employee (groupId);
create index IX_D30E8FE2 on Employee_Employee (name[$COLUMN_LENGTH:75$], salary);
create index IX_37482E3D on Employee_Employee (projectId, salary);
create index IX_B14813D9 on Employee_Employee (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2545BC9B on Employee_Employee (uuid_[$COLUMN_LENGTH:75$], groupId);