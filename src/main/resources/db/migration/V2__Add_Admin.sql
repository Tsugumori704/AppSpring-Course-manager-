INSERT INTO users (id, activation_code, active, birth_date, email, first_name, last_name, password, sur_name, username)
VALUES (1, null, true, '2019-10-01', 'Admin@some.by', 'Morton', 'Lopez', '1', 'Hayes', 'admin');

insert into user_role(user_id, roles)
values (1, 'ADMIN');

INSERT INTO users (id, activation_code, active, birth_date, email, first_name, last_name, password, sur_name, username)
VALUES (2, null, true, '2009-01-01', 'User1@some.by', 'Aguilar', 'Guerrero', '1', 'Arnold ', 'u1');

insert into user_role(user_id, roles)
values (2, 'USER');

INSERT INTO users (id, activation_code, active, birth_date, email, first_name, last_name, password, sur_name, username)
VALUES (3, null, true, '2003-02-15', 'User2@some.by', 'Henry ', 'Fleming', '1', 'Thomas', 'u2');

insert into user_role(user_id, roles)
values (3, 'USER');

INSERT INTO users (id, activation_code, active, birth_date, email, first_name, last_name, password, sur_name, username)
VALUES (4, null, true, '2008-05-06', 'User3@some.by', 'Baker ', 'Kemp', '1', 'Cummings ', 'u3');

insert into user_role(user_id, roles)
values (4, 'USER');

INSERT INTO users (id, activation_code, active, birth_date, email, first_name, last_name, password, sur_name, username)
VALUES (5, null, true, '2011-06-21', 'User4@some.by', 'Morton', 'Lopez', '1', 'Hayes', 'u4');

insert into user_role(user_id, roles)
values (5, 'USER');

INSERT INTO users (id, activation_code, active, birth_date, email, first_name, last_name, password, sur_name, username)
VALUES (6, null, true, '2008-05-06', 'Teacher1@some.by', 'Ingram', 'Murray', '1', 'Bailey', 't1');

insert into user_role(user_id, roles)
values (6, 'TEACHER');

INSERT INTO users (id, activation_code, active, birth_date, email, first_name, last_name, password, sur_name, username)
VALUES (7, null, true, '2008-05-06', 'Teacher2@some.by', 'Bowers', 'Gill', '1', 'Davidson', 't2');

insert into user_role(user_id, roles)
values (7, 'TEACHER');

INSERT INTO users (id, activation_code, active, birth_date, email, first_name, last_name, password, sur_name, username)
VALUES (8, null, true, '2008-05-06', 'Teacher3@some.by', 'Sanchez', 'Baldwin', '1', 'Elliott', 't3');

insert into user_role(user_id, roles)
values (8, 'TEACHER');
