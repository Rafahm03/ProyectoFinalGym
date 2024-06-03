
INSERT INTO USUARIO(id, username, password, ADMIN) VALUES (1, 'admin', '{bcrypt}$2a$12$ZHQTnMjgmzUVauuL5Swvt.62M4Dgf68uEvKn73bBmq867CgJ2OJEq', true);
INSERT INTO USUARIO(id, username, password, ADMIN) VALUES (2, 'user', '{bcrypt}$2a$12$5c6aIfX.993q17DcoxdJjOKK/rZ4CNlQIc3karf/Q.utqtkWd2WWW', false);
INSERT INTO USUARIO(id, username, password, ADMIN) VALUES (3, 'rafa', '{bcrypt}$2a$12$.whW94BjEoBx.mUXNfeVIeZxCLfs61EVCzE/BQXT7Iumi.lTBVqLC', false);
INSERT INTO USUARIO(id, username, password, ADMIN) VALUES (4, 'edu', '{bcrypt}$2a$12$13ukIN72kcsYpVuXBKl02OZJDZ32895ZyzzX7i/qJ8r8OdUAk5xXK', false);
INSERT INTO USUARIO(id, username, password, ADMIN) VALUES (5, 'josel', '{bcrypt}$2a$12$bRultAt1GXSU.LwQYmazrONt3zHeES96ZkQxygd1pFpLDWqTCYzA6', false);

ALTER SEQUENCE usuario_seq RESTART WITH 60;

