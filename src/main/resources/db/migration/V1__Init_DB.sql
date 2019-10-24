create sequence hibernate_sequence start 1 increment 1;

create table course (
        id int8 not null,
        course_name varchar(255),
        description varchar(2048),
        end_date date,
        is_active boolean not null,
        start_date date,
        teacher_id int8,
        primary key (id)
);

create table course_group (
        id int8 not null,
        grade_on_course int8,
        course_id int8,
        user_id int8,
        primary key (id)
);

create table user_role (
        user_id int8 not null,
        roles varchar(255)
);

create table users (
        id int8 not null,
        activation_code varchar(255),
        active boolean not null,
        birth_date date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        sur_name varchar(255),
        username varchar(255),
        primary key (id)
);

alter table if exists course_group add constraint course_group_course_user_uniq unique (course_id, user_id);
alter table if exists course add constraint teacher_id_fk foreign key (teacher_id) references users;
alter table if exists course_group add constraint course_group_course_fk foreign key (course_id) references course;
alter table if exists course_group add constraint course_group_user_fk foreign key (user_id) references users;
alter table if exists user_role add constraint user_role_fk foreign key (user_id) references users;