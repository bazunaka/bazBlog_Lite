create table public.bazblog_user_accounts
(
    id serial primary key ,
    username varchar(32) unique not null ,
    password varchar(128) not null
);
--rollback drop table public.bazblog_user_accounts;

create table public.bazblog_user_roles
(
    id serial primary key ,
    authority varchar(32) unique not null
);
--rollback drop table public.bazblog_user_roles;

create table public.bazblog_user_accounts_roles
(
    user_account_id integer not null ,
    user_role_id integer not null
);
--rollback drop table public.bazblog_user_accounts_roles;

alter table public.bazblog_user_accounts_roles
    add constraint user_accounts_roles__user_roles_fk
        foreign key (user_role_id) references public.bazblog_user_roles (id);

alter table public.bazblog_user_accounts_roles
    add constraint user_accounts_roles__user_accounts_fk
        foreign key (user_id) references public.bazblog_users (id);

alter table public.bazblog_user_accounts_roles
    add constraint user_accounts_roles_unique
        unique (user_id, user_role_id);

insert into public.bazblog_user_roles(authority)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

create table public.bazblog_user_profiles
(
    id integer primary key ,
    nickname varchar(32) unique not null ,
    imageLink varchar(128) not null
);
--rollback drop table public.bazblog_user_profiles;

alter table public.bazblog_user_profiles
    add constraint user_profiles__user_accounts_fk
        foreign key (id) references public.bazblog_users (id);

alter table public.bazblog_user_profiles
    add constraint user_profiles_nickname__unique
        unique (nickname);

create table public.bazblog_posts
(
    id serial primary key ,
    message varchar(180) not null ,
    user_profile_id integer not null ,
    createdTime timestamp not null
);

alter table public.bazblog_posts
    add constraint tweets__user_profiles_fk
        foreign key (user_profile_id) references public.bazblog_user_profiles (id);

alter table public.bazblog_posts
    add column modifiedTime timestamp;

update public.bazblog_posts
    set modifiedTime = created_time
    where bazblog_posts.modifiedTime is null;

alter table public.bazblog_posts
    alter column modifiedTime set not null;