CREATE TABLE psp
(
    id         uuid PRIMARY KEY,
    created_at timestamptz  NOT NULL,
    updated_at timestamptz  NOT NULL,
    version    bigint       NOT NULL,
    name       varchar(255) NOT NULL UNIQUE,
    status     varchar(40)  NOT NULL
);

CREATE TABLE app_user
(
    id            uuid PRIMARY KEY,
    created_at    timestamptz  NOT NULL,
    updated_at    timestamptz  NOT NULL,
    version       bigint       NOT NULL,
    psp_id        uuid REFERENCES psp (id),
    email         varchar(255) NOT NULL,
    password_hash varchar(255) NOT NULL,
    status        varchar(40)  NOT NULL
);

CREATE TABLE role_grant
(
    id         uuid PRIMARY KEY,
    created_at timestamptz NOT NULL,
    updated_at timestamptz NOT NULL,
    version    bigint      NOT NULL,
    user_id    uuid        NOT NULL REFERENCES app_user (id),
    role       varchar(40) NOT NULL,
    granted_by uuid REFERENCES app_user (id),
    UNIQUE (user_id, role)
);


CREATE UNIQUE INDEX uq_app_user_email ON app_user (lower(email));