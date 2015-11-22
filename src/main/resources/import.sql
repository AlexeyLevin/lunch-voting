-- user@yandex.ru : password
-- admin@gmail.com: admin
INSERT INTO USERS (ID, EMAIL, NAME, PASSWORD) VALUES
(0, 'user@yandex.ru', 'User', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni'),
(1, 'admin@gmail.com', 'Admin', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju');

INSERT INTO USER_ROLES (ROLE, USER_ID) VALUES ('ROLE_USER', 0), ('ROLE_ADMIN', 1);

INSERT INTO RESTAURANT (ID,NAME) VALUES (0,'McDonalds'), (1,'Шаляпин'), (2,'Васаби');

INSERT INTO MENU (ID, MENU_DATE, RESTAURANT_ID) VALUES
(0, '2015-11-20', 0), (1, '2015-11-19', 0),
(2, '2015-11-20', 1), (3, '2015-11-19', 1),
(4, '2015-11-20', 2), (5, '2015-11-19', 2);

INSERT INTO LUNCH (NAME, PRICE, MENU_ID) VALUES
('Гамбургер', 350, 0), ('Фри', 95, 0),
('Вчерашний Гамбургер', 340, 1), ('Вчерашнее Фри', 90, 1),
('Суп', 650, 2), ('Второе', 750, 2),
('Вчерашний Суп', 660, 3), ('Вчерашнее Второе', 705, 3),
('Суши', 450, 4), ('Лосось', 560, 4),
('Вчерашний Суши', 455, 5), ('Вчерашний Лосось', 520, 5);
