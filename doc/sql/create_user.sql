create user app
identified by "password"
default tablespace users
temporary tablespace temp;

grant create session to app;
alter user app quota unlimited on users;
