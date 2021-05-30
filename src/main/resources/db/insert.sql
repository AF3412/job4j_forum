INSERT INTO authorities (authority) VALUES ('ROLE_USER');
INSERT INTO authorities (authority) VALUES ('ROLE_ADMIN');

INSERT INTO users (username, password, authority_id)
VALUES ('root', '$2a$10$PGmLzM6OE0lXfL5lnFp1ruosgCjbx1voYHV.1bAZLkxua0dYqMFm2',
        (SELECT id FROM authorities WHERE authority = 'ROLE_ADMIN'));

INSERT INTO posts (name, description, created) VALUES ('О чем этот форум?', 'Обо всем', NOW());
INSERT INTO posts (name, description, created) VALUES ('Правила форума.', 'Будьте вежливы', NOW());

INSERT INTO user_posts (user_id, post_id)
VALUES ((SELECT id FROM users WHERE username = 'root'),
        (SELECT id FROM posts WHERE name = 'О чем этот форум?'));

INSERT INTO user_posts (user_id, post_id)
VALUES ((SELECT id FROM users WHERE username = 'root'),
        (SELECT id FROM posts WHERE name = 'Правила форума.'));