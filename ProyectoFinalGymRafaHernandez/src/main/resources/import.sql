-- ALTER TABLE PARA AJUSTAR LA LONGITUD DE DESCRIPCION
ALTER TABLE clases ALTER COLUMN descripcion TYPE VARCHAR(500);

-- INSERT INTO DE CUOTA
INSERT INTO cuota (id, nombre, descripcion, precio) VALUES (1, 'Cuota Diaria', 'Cuota diaria, acceso a las instalaciones un dia entero', 9.99);
INSERT INTO cuota (id, nombre, descripcion, precio) VALUES (2, 'Cuota Mensual', 'Cuota mensual, acceso a las instalaciones durante un mes', 25.99);
INSERT INTO cuota (id, nombre, descripcion, precio) VALUES (3, 'Cuota Anual', 'Cuota anual, acceso a las instalaciones durante un año', 189.99);

ALTER SEQUENCE cuota_seq RESTART WITH 54;

-- INSERT INTO DE PLAN
INSERT INTO plan (id, nombre, descripcion, precio, cuota_id) VALUES (1, 'Plan Básico', 'Plan básico que ofrece clases grabadas y acceso limitado a las instalaciones', 9.99, 1);
INSERT INTO plan (id, nombre, descripcion, precio, cuota_id) VALUES (2, 'Plan Medium', 'Plan Medium que ofrece acceso ilimitado a las instalaciones y complementos personalizados del gym', 15.99, 2);
INSERT INTO plan (id, nombre, descripcion, precio, cuota_id) VALUES (3, 'Plan Premium', 'Plan Premium que ofrece entrenador personal y seguimiento con plan de nutrición', 20.99, 3);

ALTER SEQUENCE plan_seq RESTART WITH 54;

-- INSERT INTO DE SOCIO
INSERT INTO socio (id, username, password, admin, nombre, apellidos, gmail, direccion, fecha_alta, plan_id, cuota_id) VALUES (1, 'admin', '{bcrypt}$2a$12$ZHQTnMjgmzUVauuL5Swvt.62M4Dgf68uEvKn73bBmq867CgJ2OJEq', true, 'Rafa', 'Hernández Meléndez', 'rafa@gmail.com', 'C/ Internet Explorer', '2024-06-03', 1, 1);
INSERT INTO socio (id, username, password, admin, nombre, apellidos, gmail, direccion, fecha_alta, plan_id, cuota_id) VALUES (2, 'user', '{bcrypt}$2a$12$5c6aIfX.993q17DcoxdJjOKK/rZ4CNlQIc3karf/Q.utqtkWd2WWW', false, 'Anonimus', 'Anonimus', 'anonimus@gmail.com', 'C/ por la red', '2008-01-01', 2, 2);
INSERT INTO socio (id, username, password, admin, nombre, apellidos, gmail, direccion, fecha_alta, plan_id, cuota_id) VALUES (3, 'rafa', '{bcrypt}$2a$12$.whW94BjEoBx.mUXNfeVIeZxCLfs61EVCzE/BQXT7Iumi.lTBVqLC', false, 'Rafa', 'Hernández', 'tuprogramadorfav@gmail.com', 'C/ whitelabelError 404', '2024-07-12', 3, 3);
INSERT INTO socio (id, username, password, admin, nombre, apellidos, gmail, direccion, fecha_alta, plan_id, cuota_id) VALUES (4, 'edu', '{bcrypt}$2a$12$13ukIN72kcsYpVuXBKl02OZJDZ32895ZyzzX7i/qJ8r8OdUAk5xXK', false, 'Eduardo', 'sisi', 'edu@gmail.com', 'C/ HogWarts', '2022-03-23', 2, 2);
INSERT INTO socio (id, username, password, admin, nombre, apellidos, gmail, direccion, fecha_alta, plan_id, cuota_id) VALUES (5, 'josel', '{bcrypt}$2a$12$bRultAt1GXSU.LwQYmazrONt3zHeES96ZkQxygd1pFpLDWqTCYzA6', false, 'José Luis', 'nose', 'pikkas@gmai.com', 'C/ El multiverso', '2023-12-04', 1, 1);

ALTER SEQUENCE socio_seq RESTART WITH 56;

-- INSERT INTO DE CLASES
INSERT INTO clase (id, capacidad_maxima, img, dias, nombre, descripcion) VALUES (1, 8, 'https://img.freepik.com/foto-gratis/personas-que-participan-clase-zumba_23-2149074871.jpg', 'Lunes y Jueves', 'Zumba', 'Las clases de Zumba, se realizan ejercicios aeróbicos al ritmo de música latina (merengue, samba, reggaeton, cumbia y salsa) con la finalidad de perder peso de forma divertida y mejorar el estado de ánimo de los deportistas.');
INSERT INTO clase (id, capacidad_maxima, img, dias, nombre, descripcion) VALUES (2, 10, 'https://img.freepik.com/foto-gratis/gente-haciendo-ciclismo-indoor_23-2149270249.jpg', 'Martes y Viernes', 'Spinning', 'Las clases de Spinning tratan de un ejercicio físico colectivo, el cual se realiza sobre una bicicleta estática al ritmo de la música.');
INSERT INTO clase (id, capacidad_maxima, img, dias, nombre, descripcion) VALUES (3, 5, 'https://st2.depositphotos.com/1518767/8185/i/450/depositphotos_81859816-stock-photo-athletes-lifting-and-jumping.jpg', 'Miércoles y Sábados', 'Crossfit', 'Las clases de Crossfit consiste en desarrollar potencia, ganar control del peso corporal y realizar ejercicios funcionales de alta intensidad para mejorar la capacidad funcional.');

ALTER SEQUENCE clases_seq RESTART WITH 54;

-- INSERT INTO DE CLASE RESERVA
INSERT INTO reserva (clase_id, fecha_reserva, socio_id, nombre_solicitante) VALUES (1,  '2024-06-07 13:15:00', 1, 'Rafa');
INSERT INTO reserva (clase_id, fecha_reserva, socio_id, nombre_solicitante) VALUES (2,  '2024-06-07 14:15:00', 2, 'User');
INSERT INTO reserva (clase_id, fecha_reserva, socio_id, nombre_solicitante) VALUES (3,  '2024-06-07 15:15:00', 5, 'jose');
INSERT INTO reserva (clase_id, fecha_reserva, socio_id, nombre_solicitante) VALUES (1,  '2024-06-08 13:15:00', 4, 'Edu');
INSERT INTO reserva (clase_id, fecha_reserva, socio_id, nombre_solicitante) VALUES (2,  '2024-06-08 14:15:00', 3, 'Rafa');
INSERT INTO reserva (clase_id, fecha_reserva, socio_id, nombre_solicitante) VALUES (3,  '2024-06-08 15:15:00', 4, 'Edu');
INSERT INTO reserva (clase_id, fecha_reserva, socio_id, nombre_solicitante) VALUES (1,  '2024-06-09 13:15:00', 2, 'User');
INSERT INTO reserva (clase_id, fecha_reserva, socio_id, nombre_solicitante) VALUES (2,  '2024-06-09 14:15:00', 1, 'Rafa');
INSERT INTO reserva (clase_id, fecha_reserva, socio_id, nombre_solicitante) VALUES (3,  '2024-06-09 15:15:00', 3, 'Rafa');
