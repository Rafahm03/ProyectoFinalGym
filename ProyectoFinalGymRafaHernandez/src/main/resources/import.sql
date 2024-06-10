-- INSERT INTO DE CUOTA
INSERT INTO cuota (id, nombre, descripcion, precio) VALUES (1, 'Cuota Diaria', 'Cuota diaria, acceso a las instalaciones un dia entero', 9.99);
INSERT INTO cuota (id, nombre, descripcion, precio) VALUES (2, 'Cuota Mensual', 'Cuota mensual, acceso a las instalaciones durante un mes', 25.99);
INSERT INTO cuota (id, nombre, descripcion, precio) VALUES (3, 'Cuota Anual', 'Cuota anual, acceso a las instalaciones durante un año', 189.99);

ALTER SEQUENCE cuota_seq RESTART WITH 54;

-- INSERT INTO DE PLAN
INSERT INTO plan (id, nombre, descripcion, precio, cuota_id) VALUES (1, 'Plan Básico', 'Plan basico que ofrece, clases grabadas y acceso limitado a las instalaciones', 9.99, 1);
INSERT INTO plan (id, nombre, descripcion, precio, cuota_id) VALUES (2, 'Plan Medium', 'Plan Medium que ofrece acceso ilimitado sobre las instalaciones y complementos personalizados del gym', 15.99, 2);
INSERT INTO plan (id, nombre, descripcion, precio, cuota_id) VALUES (3, 'Plan Premium', 'Plan Premium que ofrece entrenador personal, y un seguimiento con plan de nutricion', 20.99, 3);

ALTER SEQUENCE plan_seq RESTART WITH 54;

-- INSERT INTO DE SOCIO
INSERT INTO socio (id, username, password, admin, nombre, apellidos, gmail, direccion, fecha_alta, plan_id, cuota_id) VALUES (1, 'admin', '{bcrypt}$2a$12$ZHQTnMjgmzUVauuL5Swvt.62M4Dgf68uEvKn73bBmq867CgJ2OJEq', true, 'Rafa', 'Hernández Meléndez', 'rafa@gmail.com', 'C/ Internet Explorer', '2024-06-03', 1, 1);
INSERT INTO socio (id, username, password, admin, nombre, apellidos, gmail, direccion, fecha_alta, plan_id, cuota_id) VALUES (2, 'user', '{bcrypt}$2a$12$5c6aIfX.993q17DcoxdJjOKK/rZ4CNlQIc3karf/Q.utqtkWd2WWW', false, 'Anonimus', 'Anonimus', 'anonimus@gmail.com', 'C/ por la red', '2008-01-01', 2, 2);
INSERT INTO socio (id, username, password, admin, nombre, apellidos, gmail, direccion, fecha_alta, plan_id, cuota_id) VALUES (3, 'rafa', '{bcrypt}$2a$12$.whW94BjEoBx.mUXNfeVIeZxCLfs61EVCzE/BQXT7Iumi.lTBVqLC', false, 'Rafa', 'Hernández', 'tuprogramadorfav@gmail.com', 'C/ whitelabelError 404', '2024-07-12', 3, 3);
INSERT INTO socio (id, username, password, admin, nombre, apellidos, gmail, direccion, fecha_alta, plan_id, cuota_id) VALUES (4, 'edu', '{bcrypt}$2a$12$13ukIN72kcsYpVuXBKl02OZJDZ32895ZyzzX7i/qJ8r8OdUAk5xXK', false, 'Eduardo', 'sisi', 'edu@gmail.com', 'C/ HogWarts', '2022-03-23', 2, 2);
INSERT INTO socio (id, username, password, admin, nombre, apellidos, gmail, direccion, fecha_alta, plan_id, cuota_id) VALUES (5, 'josel', '{bcrypt}$2a$12$bRultAt1GXSU.LwQYmazrONt3zHeES96ZkQxygd1pFpLDWqTCYzA6', false, 'José Luis', 'nose', 'pikkas@gmai.com', 'C/ El multiverso', '2023-12-04', 1, 1);

ALTER SEQUENCE socio_seq RESTART WITH 56;

