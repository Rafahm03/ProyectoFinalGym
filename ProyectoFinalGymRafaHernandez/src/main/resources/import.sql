
INSERT INTO Socio(id, username, password, ADMIN, nombre, apellidos, gmail, direccion, fecha_alta) VALUES (1, 'admin', '{bcrypt}$2a$12$ZHQTnMjgmzUVauuL5Swvt.62M4Dgf68uEvKn73bBmq867CgJ2OJEq', true, 'Rafa', 'Hernández Meléndez', 'rafa@gmail.com', 'C/ Internet Explorer', '2024-06-03');
INSERT INTO Socio(id, username, password, ADMIN, nombre, apellidos, gmail, direccion, fecha_alta) VALUES (2, 'user', '{bcrypt}$2a$12$5c6aIfX.993q17DcoxdJjOKK/rZ4CNlQIc3karf/Q.utqtkWd2WWW', false, 'Anonimus', 'Anonimus', 'anonimus@gmail.com', 'C/ por la red', '2008-01-01');
INSERT INTO Socio(id, username, password, ADMIN, nombre, apellidos, gmail, direccion, fecha_alta) VALUES (3, 'rafa', '{bcrypt}$2a$12$.whW94BjEoBx.mUXNfeVIeZxCLfs61EVCzE/BQXT7Iumi.lTBVqLC', false, 'Rafa', 'Hernández', 'tuprogramadorfav@gmail.com', 'C/ whitelabelError 404', '2024-07-12');
INSERT INTO Socio(id, username, password, ADMIN, nombre, apellidos, gmail, direccion, fecha_alta) VALUES (4, 'edu', '{bcrypt}$2a$12$13ukIN72kcsYpVuXBKl02OZJDZ32895ZyzzX7i/qJ8r8OdUAk5xXK', false, 'Eduardo', 'sisi', 'edu@gmail.com', 'C/ HogWarts', '2022-03-23');
INSERT INTO Socio(id, username, password, ADMIN, nombre, apellidos, gmail, direccion, fecha_alta) VALUES (5, 'josel', '{bcrypt}$2a$12$bRultAt1GXSU.LwQYmazrONt3zHeES96ZkQxygd1pFpLDWqTCYzA6', false, 'José Luis', 'nose', 'pikkas@gmai.com', 'C/ El multiverso', '2023-12-04');

ALTER SEQUENCE socio_seq RESTART WITH 60;

