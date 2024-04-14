CREATE TABLE users (
                       id         SERIAL PRIMARY KEY,
                       role       VARCHAR(32)   NOT NULL,
                       username   VARCHAR(64)   NOT NULL UNIQUE,
                       password   VARCHAR(2048) NOT NULL,
                       first_name VARCHAR(64)   NOT NULL,
                       last_name  VARCHAR(64)   NOT NULL,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP
);


CREATE TABLE task (
                       id         SERIAL PRIMARY KEY,
                       status   VARCHAR(32),
                       title   VARCHAR(428),
                       text       VARCHAR(2048),
                       owner_id INT REFERENCES users(id) NOT NULL,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP
);

CREATE TABLE responsible_users
    (
    responsible_id INT REFERENCES task (id) ON DELETE CASCADE,
    username VARCHAR(255) NOT NULL
    );

CREATE TABLE users_comments
(
    comment_id INT REFERENCES task (id) ON DELETE CASCADE,
    comment VARCHAR(255) NOT NULL
);


