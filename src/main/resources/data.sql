INSERT INTO role(user_id, name) VALUES (1, 'ROLE_TRAINER')
INSERT INTO role(user_id, name) VALUES (2, 'ROLE_SPORTER')
INSERT INTO role(user_id, name) VALUES (3, 'ROLE_ADMIN')

-- //register
INSERT INTO app_user_sport(user_id, email, first_name, last_name, password, username) VALUES(100, 'jan@user.nl', 'Jan', 'Jansen', '12345678', 'Jan')
INSERT INTO app_user_sport(user_id, email, first_name, last_name, password, username) VALUES(101, 'janneke@user.nl', 'Janneke', 'Van de Ven', '12345678', 'Jannie')
INSERT INTO app_user_sport(user_id, email, first_name, last_name, password, username) VALUES(102, 'marloe@user.nl', 'Marloe', 'Heeze', '12345678', 'Marloe100')
INSERT INTO app_user_sport(user_id, email, first_name, last_name, password, username) VALUES(103, 'mohammed@user.nl', 'Mohammed', 'Abu-Backer', '12345678', 'Mo')
INSERT INTO app_user_sport(user_id, email, first_name, last_name, password, username) VALUES(104, 'tim@user.nl', 'Tim', 'Van Loon', '12345678', 'Tim')
INSERT INTO app_user_sport(user_id, email, first_name, last_name, password, username) VALUES(105, 'emre@user.nl', 'Emre', 'Ozturk', '12345678', 'Emre')

INSERT INTO app_user_sport(user_id, email, first_name, last_name, password, username) VALUES(106, 'sporter@user.nl', 'sporter', 'sporter', '12345678', 'sporter')


--//user_id
INSERT INTO user_role(user_id, role_id) VALUES (100, 1)
INSERT INTO user_role(user_id, role_id) VALUES (101, 1)
INSERT INTO user_role(user_id, role_id) VALUES (102, 1)
INSERT INTO user_role(user_id, role_id) VALUES (103, 1)
INSERT INTO user_role(user_id, role_id) VALUES (104, 1)
INSERT INTO user_role(user_id, role_id) VALUES (105, 1)
INSERT INTO user_role(user_id, role_id) VALUES (106, 2)


--//activity
INSERT INTO activity(activity_id, activity_name, name_trainer, address, city, zipcode, time, date, trainer_user_id) VALUES (111, 'Boksen', 'Jan', 'Stadswandelpark', 'Eindhoven', '5615EK','12:00', '28-02-2021', 100)
INSERT INTO activity(activity_id, activity_name, name_trainer, address, city, zipcode, time, date, trainer_user_id) VALUES (112, 'Yoga', 'Marloe', 'Recreatieplas Hanevoet, Klotputten', 'Eindhoven','null','12:00', '28-02-2021', 102)
INSERT INTO activity(activity_id, activity_name, name_trainer, address, city, zipcode, time, date, trainer_user_id) VALUES (113, 'Thai Boksen', 'Tim', 'Henri Dunantpark, Rode Kruislaan 14', 'Eindhoven','null','12:00', '28-02-2021', 104)
INSERT INTO activity(activity_id, activity_name, name_trainer, address, city, zipcode, time, date, trainer_user_id) VALUES (114, 'Bootcamp', 'Janneke', 'Philips de Jongh park, Oirschotsedijk 2', 'Eindhoven','5651GC ','12:00', '28-02-2021', 101)
INSERT INTO activity(activity_id, activity_name, name_trainer, address, city, zipcode, time, date, trainer_user_id) VALUES (115, 'Cross-Fit', 'Mohammed', 'Karpendonkse Plas, Sumatralaan', 'Eindhoven','null','12:00', '28-02-2021', 103)
INSERT INTO activity(activity_id, activity_name, name_trainer, address, city, zipcode, time, date, trainer_user_id) VALUES (116, 'Boksen', 'Emre', 'Philips van Lenneppark, Pieter Stockmanslaan 5','Eindhoven','5657BB','12:00', '28-02-2021', 105)
INSERT INTO activity(activity_id, activity_name, name_trainer, address, city, zipcode, time, date, trainer_user_id) VALUES (117, 'Judo', 'Jan', 'TU/e Campus', 'Eindhoven','5612AZ','12:00', '28-02-2021', 100)
INSERT INTO activity(activity_id, activity_name, name_trainer, address, city, zipcode, time, date, trainer_user_id) VALUES (118, 'Kick Boksen', 'Emre', 'Dommelplantsoen, Jacob van Maerlantlaan', 'Eindhoven','null','12:00', '28-02-2021', 105)

--//latLng
-- INSERT INTO location(location_id, address, city, zipcode, lat, lng, activity_activity_id) VALUES (120, 'Stadswandelpark', 'Eindhoven', '5615EK', 51.426200, 5.475239, 111)
-- INSERT INTO location(location_id, address, city, zipcode, lat, lng, activity_activity_id) VALUES (121, 'Recreatieplas Hanevoet, Klotputten', 'Eindhoven','null', 51.410999, 5.441473, 112)
-- INSERT INTO location(location_id, address, city, zipcode, lat, lng, activity_activity_id) VALUES (122, 'Henri Dunantpark, Rode Kruislaan 14', 'Eindhoven','null', 51.480062, 5.471733, 113)
-- INSERT INTO location(location_id, address, city, zipcode, lat, lng, activity_activity_id) VALUES (123, 'Philips de Jongh park, Oirschotsedijk 2', 'Eindhoven','5651GC', 51.457659, 5.441887, 114)
-- INSERT INTO location(location_id, address, city, zipcode, lat, lng, activity_activity_id) VALUES (124, 'Karpendonkse Plas, Sumatralaan', 'Eindhoven','null', 51.452188, 5.498033, 115)
-- INSERT INTO location(location_id, address, city, zipcode, lat, lng, activity_activity_id) VALUES (125, 'Philips van Lenneppark, Pieter Stockmanslaan 5','Eindhoven','5657BB', 51.446571, 5.431258, 116)
-- INSERT INTO location(location_id, address, city, zipcode, lat, lng, activity_activity_id) VALUES (126, 'TU/e Campus', 'Eindhoven','5612AZ', 51.451441, 5.486014, 117)
-- INSERT INTO location(location_id, address, city, zipcode, lat, lng, activity_activity_id) VALUES (127, 'Dommelplantsoen, Jacob van Maerlantlaan', 'Eindhoven','null', 51.426200, 5.475239, 118)

INSERT INTO location(location_id, lat, lng, activity_activity_id) VALUES (120, 51.426200, 5.475239, 111)
INSERT INTO location(location_id, lat, lng, activity_activity_id) VALUES (121, 51.410999, 5.441473, 112)
INSERT INTO location(location_id, lat, lng, activity_activity_id) VALUES (122, 51.480062, 5.471733, 113)
INSERT INTO location(location_id, lat, lng, activity_activity_id) VALUES (123, 51.457659, 5.441887, 114)
INSERT INTO location(location_id, lat, lng, activity_activity_id) VALUES (124, 51.452188, 5.498033, 115)
INSERT INTO location(location_id, lat, lng, activity_activity_id) VALUES (125, 51.446571, 5.431258, 116)
INSERT INTO location(location_id, lat, lng, activity_activity_id) VALUES (126, 51.451441, 5.486014, 117)
INSERT INTO location(location_id, lat, lng, activity_activity_id) VALUES (127, 51.426200, 5.475239, 118)


--//activity_type
INSERT INTO activity_type(activity_type_id, activity_name) VALUES (111, 'Boksen')
INSERT INTO activity_type(activity_type_id, activity_name) VALUES (112, 'Yoga')
INSERT INTO activity_type(activity_type_id, activity_name) VALUES (113, 'Thai Boksen')
INSERT INTO activity_type(activity_type_id, activity_name) VALUES (114, 'Bootcamp')
INSERT INTO activity_type(activity_type_id, activity_name) VALUES (115, 'Cross Fit')
INSERT INTO activity_type(activity_type_id, activity_name) VALUES (116, 'Kick Boksen')
INSERT INTO activity_type(activity_type_id, activity_name) VALUES (118, 'Judo')

--//sporter_activity
INSERT INTO sporter_activity(user_id, activity_id) VALUES (106, 111)
INSERT INTO sporter_activity(user_id, activity_id) VALUES (106, 112)
INSERT INTO sporter_activity(user_id, activity_id) VALUES (106, 113)