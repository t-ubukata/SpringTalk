create role app_role;

grant create session
  to app_role;

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

grant select
  on app.user_id_sequence
  to app_role;

grant select
  on app.room_id_sequence
  to app_role;

grant select
  on app.message_id_sequence
  to app_role;

grant select
  on app.membership_id_sequence
  to app_role;

grant app_role
  to app;
