insert into TEAM (id, name) values (uuid(), 'Mercedes');
insert into TEAM (id, name) values (uuid(), 'Ferrari');
insert into TEAM (id, name) values (uuid(), 'Red Bull Racing');
insert into TEAM (id, name) values (uuid(), 'McLaren');
insert into TEAM (id, name) values (uuid(), 'Alpine');
insert into TEAM (id, name) values (uuid(), 'Aston Martin');
insert into TEAM (id, name) values (uuid(), 'AlphaTauri');
insert into TEAM (id, name) values (uuid(), 'Alfa Romeo');
insert into TEAM (id, name) values (uuid(), 'Haas');
insert into TEAM (id, name) values (uuid(), 'Williams');

insert into DRIVER (id, name, number, team_id) values (uuid(), 'Lewis Hamilton', 44, (select id from TEAM where name = 'Mercedes'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'George Russell', 63, (select id from TEAM where name = 'Mercedes'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Carlos Sainz', 55, (select id from TEAM where name = 'Ferrari'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Charles Leclerc', 16, (select id from TEAM where name = 'Ferrari'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Max Verstappen', 1, (select id from TEAM where name = 'Red Bull Racing'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Sergio Perez', 11, (select id from TEAM where name = 'Red Bull Racing'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Lando Norris', 4, (select id from TEAM where name = 'McLaren'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Oscar Piastri', 81, (select id from TEAM where name = 'McLaren'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Esteban Ocon', 31, (select id from TEAM where name = 'Alpine'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Pierre Gasly', 10, (select id from TEAM where name = 'Alpine'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Fernando Alonso', 14, (select id from TEAM where name = 'Aston Martin'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Lance Stroll', 18, (select id from TEAM where name = 'Aston Martin'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Yuki Tsunoda', 22, (select id from TEAM where name = 'AlphaTauri'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Daniel Ricciardo', 3, (select id from TEAM where name = 'AlphaTauri'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Valtteri Bottas', 77, (select id from TEAM where name = 'Alfa Romeo'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Zhou Guanyu', 24, (select id from TEAM where name = 'Alfa Romeo'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Kevin Magnussen', 20, (select id from TEAM where name = 'Haas'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Nico Hulkenberg', 27, (select id from TEAM where name = 'Haas'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Alex Albon', 23, (select id from TEAM where name = 'Williams'));
insert into DRIVER (id, name, number, team_id) values (uuid(), 'Logan Sargeant', 2, (select id from TEAM where name = 'Williams'));

insert into RACE (id, name, raceYear) values (uuid(), 'Bahrain Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Saudi Arabian Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Australian Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Azerbaijan Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Miami Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Emilia Romagna Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Monaco Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Spanish Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Canadian Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Austrian Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'British Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Hungarian Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Belgian Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Dutch Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Italian Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Singapore Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Japanese Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Qatar Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'United States Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Mexico City Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'São Paulo Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Las Vegas Grand Prix', 2024);
insert into RACE (id, name, raceYear) values (uuid(), 'Abu Dhabi Grand Prix', 2024);

insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Max Verstappen'), 1, true);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Sergio Perez'), 2, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Lewis Hamilton'), 3, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'George Russell'), 4, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Charles Leclerc'), 5, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Carlos Sainz'), 6, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Lando Norris'), 7, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Oscar Piastri'), 8, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Fernando Alonso'), 9, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Esteban Ocon'), 10, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Pierre Gasly'), 11, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Yuki Tsunoda'), 12, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Valtteri Bottas'), 13, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Zhou Guanyu'), 14, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Kevin Magnussen'), 15, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Nico Hulkenberg'), 16, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Alex Albon'), 17, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Logan Sargeant'), 18, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Lance Stroll'), 19, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Daniel Ricciardo'), 20, false);

insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Max Verstappen'), 1, true);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Charles Leclerc'), 2, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'George Russell'), 3, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Lewis Hamilton'), 4, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Sergio Perez'), 5, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Carlos Sainz'), 6, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Lando Norris'), 7, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Oscar Piastri'), 8, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Fernando Alonso'), 9, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Esteban Ocon'), 10, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Pierre Gasly'), 11, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Yuki Tsunoda'), 12, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Valtteri Bottas'), 13, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Zhou Guanyu'), 14, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Kevin Magnussen'), 15, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Nico Hulkenberg'), 16, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Alex Albon'), 17, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Logan Sargeant'), 18, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Lance Stroll'), 19, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Saudi Arabian Grand Prix'), (select id from DRIVER where name = 'Daniel Ricciardo'), 20, false);


insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Lewis Hamilton'), 1, true);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Carlos Sainz'), 2, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Charles Leclerc'), 3, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Max Verstappen'), 4, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Sergio Perez'), 5, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'George Russell'), 6, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Lando Norris'), 7, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Alex Albon'), 8, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Pierre Gasly'), 9, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Fernando Alonso'), 10, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Esteban Ocon'), 11, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Yuki Tsunoda'), 12, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Valtteri Bottas'), 13, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Zhou Guanyu'), 14, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Kevin Magnussen'), 15, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Nico Hulkenberg'), 16, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Oscar Piastri'), 17, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Logan Sargeant'), 18, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Lance Stroll'), 19, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Australian Grand Prix'), (select id from DRIVER where name = 'Daniel Ricciardo'), 20, false);

insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Max Verstappen'), 1, true);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Sergio Perez'), 2, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'George Russell'), 3, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Lewis Hamilton'), 4, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Charles Leclerc'), 5, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Nico Hulkenberg'), 6, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Lando Norris'), 7, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Oscar Piastri'), 8, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Fernando Alonso'), 9, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Pierre Gasly'), 10, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Esteban Ocon'), 11, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Yuki Tsunoda'), 12, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Valtteri Bottas'), 13, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Zhou Guanyu'), 14, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Kevin Magnussen'), 15, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Carlos Sainz'), 16, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Oscar Piastri'), 17, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Logan Sargeant'), 18, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Lance Stroll'), 19, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Azerbaijan Grand Prix'), (select id from DRIVER where name = 'Daniel Ricciardo'), 20, false);


insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Max Verstappen'), 1, true);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Charles Leclerc'), 2, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Lewis Hamilton'), 3, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Yuki Tsunoda'), 4, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Daniel Ricciardo'), 5, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Carlos Sainz'), 6, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Lando Norris'), 7, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Oscar Piastri'), 8, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Fernando Alonso'), 9, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Pierre Gasly'), 10, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Esteban Ocon'), 11, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Sergio Perez'), 12, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'George Russell'), 13, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Valtteri Bottas'), 14, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Zhou Guanyu'), 15, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Kevin Magnussen'), 16, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Nico Hulkenberg'), 17, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Oscar Piastri'), 18, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Logan Sargeant'), 19, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Miami Grand Prix'), (select id from DRIVER where name = 'Lance Stroll'), 20, false);

insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Max Verstappen'), 1, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Sergio Perez'), 2, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'George Russell'), 3, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Lewis Hamilton'), 4, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Charles Leclerc'), 5, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Carlos Sainz'), 6, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Lando Norris'), 7, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Oscar Piastri'), 8, true);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Fernando Alonso'), 9, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Daniel Ricciardo'), 10, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Esteban Ocon'), 11, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Sergio Perez'), 12, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Yuki Tsunoda'), 13, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Valtteri Bottas'), 14, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Zhou Guanyu'), 15, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Kevin Magnussen'), 16, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Nico Hulkenberg'), 17, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Pierre Gasly'), 18, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Logan Sargeant'), 19, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Emilia Romagna Grand Prix'), (select id from DRIVER where name = 'Lance Stroll'), 20, false);

insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Monaco Grand Prix'), (select id from DRIVER where name = 'Max Verstappen'), 1, true);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Monaco Grand Prix'), (select id from DRIVER where name = 'Charles Leclerc'), 2, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Monaco Grand Prix'), (select id from DRIVER where name = 'Lewis Hamilton'), 3, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Monaco Grand Prix'), (select id from DRIVER where name = 'George Russell'), 4, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Monaco Grand Prix'), (select id from DRIVER where name = 'Sergio Perez'), 5, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Monaco Grand Prix'), (select id from DRIVER where name = 'Carlos Sainz'), 6, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Monaco Grand Prix'), (select id from DRIVER where name = 'Lando Norris'), 7, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Monaco Grand Prix'), (select id from DRIVER where name = 'Oscar Piastri'), 8, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Monaco Grand Prix'), (select id from DRIVER where name = 'Fernando Alonso'), 9, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Nico Hulkenberg'), 10, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Monaco Grand Prix'), (select id from DRIVER where name = 'Esteban Ocon'), 11, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Pierre Gasly'), 12, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Yuki Tsunoda'), 13, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Valtteri Bottas'), 14, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Zhou Guanyu'), 15, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Kevin Magnussen'), 16, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Alex Albon'), 17, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Logan Sargeant'), 18, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Lance Stroll'), 19, false);
insert into RACERESULT (id, race_id, driver_id, position, fastestLap) values (uuid(), (select id from RACE where name = 'Bahrain Grand Prix'), (select id from DRIVER where name = 'Daniel Ricciardo'), 20, false);