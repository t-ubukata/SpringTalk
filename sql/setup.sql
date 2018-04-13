-- create user
create user app
  identified by "password"
  default tablespace users
  quota unlimited on users
  temporary tablespace temp;

-- create table
create table app.users (
  id number generated always as identity primary key,
  name nvarchar2(32) not null,
  password nvarchar2(32) not null);

create table app.rooms (
  id number generated always as identity primary key,
  owner_id number references app.users(id));

create table app.memberships (
  membership_id number generated always as identity primary key,
  room_id number references app.users(id),
  user_id number references app.rooms(id));

create table app.messages (
  id number generated always as identity primary key,
  sender_id number references app.users(id),
  room_id number references app.rooms(id),
  text nvarchar2(256) not null,
  created_at timestamp default systimestamp not null);

-- create sequence
create sequence app.user_id_sequence;
create sequence app.room_id_sequence;
create sequence app.message_id_sequence;
create sequence app.membership_id_sequence;

-- create role
create role app_role;

-- grant
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

