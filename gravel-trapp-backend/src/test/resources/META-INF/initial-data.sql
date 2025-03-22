insert into Team (id, name) values (random_uuid(), 'Mercedes');
insert into Team (id, name) values (random_uuid(), 'Ferrari');
insert into Team (id, name) values (random_uuid(), 'Red Bull Racing');

insert into Driver (id, name, number, team_id) values (random_uuid(), 'Lewis Hamilton', 44, (select id from Team where name = 'Mercedes'));
insert into Driver (id, name, number, team_id) values (random_uuid(), 'George Russell', 63, (select id from Team where name = 'Mercedes'));
insert into Driver (id, name, number, team_id) values (random_uuid(), 'Carlos Sainz', 55, (select id from Team where name = 'Ferrari'));
insert into Driver (id, name, number, team_id) values (random_uuid(), 'Charles Leclerc', 16, (select id from Team where name = 'Ferrari'));
insert into Driver (id, name, number, team_id) values (random_uuid(), 'Max Verstappen', 1, (select id from Team where name = 'Red Bull Racing'));
insert into Driver (id, name, number, team_id) values (random_uuid(), 'Sergio Perez', 11, (select id from Team where name = 'Red Bull Racing'));

insert into Race (id, name, raceYear) values (random_uuid(), 'Australian Grand Prix', 2022);
insert into Race (id, name, raceYear) values (random_uuid(), 'Bahrain Grand Prix', 2022);

insert into RaceResult (id, race_id, driver_id, position, fastestLap) values (random_uuid(), (select id from Race where name = 'Australian Grand Prix'), (select id from Driver where name = 'Lewis Hamilton'), 1, true);
insert into RaceResult (id, race_id, driver_id, position, fastestLap) values (random_uuid(), (select id from Race where name = 'Australian Grand Prix'), (select id from Driver where name = 'Carlos Sainz'),2,false);
insert into RaceResult (id, race_id, driver_id, position, fastestLap) values (random_uuid(), (select id from Race where name = 'Australian Grand Prix'), (select id from Driver where name = 'Charles Leclerc'),3,false);
