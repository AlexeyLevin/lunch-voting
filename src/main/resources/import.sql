DELETE FROM user_roles;
DELETE FROM users;

-- password
INSERT INTO users (id, email, name, password) VALUES (0, 'user@yandex.ru', 'User', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni');
-- admin
INSERT INTO users (id, email, name, password) VALUES (1, 'admin@gmail.com', 'Admin', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju');

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 0);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_ADMIN', 1);