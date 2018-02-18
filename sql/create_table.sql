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
