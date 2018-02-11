create role app_role;

grant select,
  insert,
  update,
  delete
  on app.users
  to app_role;

grant select,
  insert,
  update,
  delete
  on app.rooms
  to app_role;

grant select,
  insert,
  update,
  delete
  on app.memberships
  to app_role;

grant select,
  insert,
  update,
  delete
  on app.messages
  to app_role;

grant create sequence
  to app_role;

grant app_role to app;
