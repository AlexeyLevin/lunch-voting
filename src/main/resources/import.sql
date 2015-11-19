-- user@yandex.ru : password
-- admin@gmail.com: admin
INSERT INTO users (id, email, name, password) VALUES (0, 'user@yandex.ru', 'User', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni'), (1, 'admin@gmail.com', 'Admin', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju');

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 0), ('ROLE_ADMIN', 1);

INSERT INTO restorant (id, name) VALUES (2, 'McDonalds'), (3, 'Шаляпин'), (4,'Васаби')

