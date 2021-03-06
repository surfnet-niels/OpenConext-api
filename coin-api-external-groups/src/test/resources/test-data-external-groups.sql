drop table team_external_groups if exists;
create table team_external_groups (
  id bigint generated by default as identity (start with 1),
  grouper_team_id varchar(255) null,
  external_groups_id bigint null,
  primary key (id)
);

drop table external_groups if exists;
create table external_groups (
  id bigint generated by default as identity (start with 1001),
  description longvarchar,
  group_provider varchar(255) null,
  identifier varchar(255) null,
  name varchar(255) null,
  primary key (id)
);

insert into external_groups (id, description, group_provider, identifier, name)
values (1, 'avans test groep', 'avans', 'urn:collab:group:avans.nl:nl.avans.avans-employee_grp', 'avans-employee_grp');

insert into external_groups (id, description, group_provider, identifier, name)
values (2, 'hz test groep', 'hz.nl', 'urn:collab:group:hz.nl:nl.hz.hz-1234', 'hz-1234');

insert into external_groups (id, description, group_provider, identifier, name)
values (3, 'hz test groep orphan', 'hz.nl', 'urn:collab:group:hz.nl:nl.hz.hz-2345', 'hz-2345');

insert into team_external_groups (id, grouper_team_id, external_groups_id)
values (1001, 'nl:surfnet:diensten:team_jasha', 1);

insert into team_external_groups (id, grouper_team_id, external_groups_id)
values (1002, 'nl:surfnet:diensten:team_okke', 1);

insert into team_external_groups (id, grouper_team_id, external_groups_id)
values (1003, 'nl:surfnet:diensten:team_okke', 2);
