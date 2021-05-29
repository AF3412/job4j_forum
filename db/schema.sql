DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS user_posts;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS posts;

CREATE TABLE posts
(
    id          SERIAL PRIMARY KEY,
    name        TEXT,
    description TEXT,
    created     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TABLE authorities
(
    id        SERIAL PRIMARY KEY,
    authority TEXT NOT NULL UNIQUE
);

CREATE TABLE users
(
    id           SERIAL PRIMARY KEY,
    username     TEXT  NOT NULL UNIQUE,
    password     TEXT NOT NULL,
    enabled      BOOLEAN DEFAULT TRUE,
    authority_id INT NOT NULL REFERENCES authorities (id)
);

insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, password, authority_id)
values ('root', '$2a$10$PGmLzM6OE0lXfL5lnFp1ruosgCjbx1voYHV.1bAZLkxua0dYqMFm2',
        (select id from authorities where authority = 'ROLE_ADMIN'));

CREATE TABLE user_posts
(
    user_id INT REFERENCES users,
    post_id INT REFERENCES posts
);

