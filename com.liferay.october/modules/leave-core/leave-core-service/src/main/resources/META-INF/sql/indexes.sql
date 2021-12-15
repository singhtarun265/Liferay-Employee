create index IX_6D3634E1 on js_Leave (userId);
create index IX_F8C0F9DB on js_Leave (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3A643B1D on js_Leave (uuid_[$COLUMN_LENGTH:75$], groupId);