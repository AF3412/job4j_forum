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

CREATE TABLE user_posts
(
    user_id INT REFERENCES users,
    post_id INT REFERENCES posts
);