CREATE TYPE rack_status_enum AS ENUM ('ACTIVE', 'RETURNED', 'REPAIR', 'OUTDATED', 'BRICKED');

CREATE SEQUENCE SEQ_TEAM_ID
    START WITH 1
    INCREMENT BY 1
    NO CYCLE ;

CREATE SEQUENCE SEQ_RACK_ID
    START WITH 1
    INCREMENT BY 1
    NO CYCLE ;

CREATE SEQUENCE SEQ_RACK_ASSET_ID
    START WITH 1
    INCREMENT BY 1
    NO CYCLE ;

CREATE SEQUENCE SEQ_TEAM_MEMBER_ID
    START WITH 1
    INCREMENT BY 1
    NO CYCLE ;

CREATE SEQUENCE SEQ_BOOKING_ID
    START WITH 1
    INCREMENT BY 1
    NO CYCLE ;





CREATE TABLE T_TEAM
(
    id               int PRIMARY KEY DEFAULT nextval('SEQ_TEAM_ID'),
    name             text,
    product          text,
    created_at       TIMESTAMP,
    modified_at      TIMESTAMP,
    default_location varchar(10)
);
CREATE TABLE T_RACK
(
    id                int PRIMARY KEY DEFAULT nextval('SEQ_RACK_ID'),
    serial_number    text,
    status           varchar(10),
    team_id          int,
    default_location varchar(10),
    created_at       TIMESTAMP,
    modified_at      TIMESTAMP,
    assembled_at     TIMESTAMP,
    FOREIGN KEY (team_id) REFERENCES T_TEAM (id)
);
CREATE TABLE T_RACK_ASSET
(
    id        int PRIMARY KEY DEFAULT nextval('SEQ_RACK_ASSET_ID'),
    asset_tag varchar(10),
    rack_id   int,
    FOREIGN KEY (rack_id) REFERENCES T_RACK (id)
);
CREATE TABLE T_TEAM_MEMBER
(
    id          int PRIMARY KEY DEFAULT nextval('SEQ_TEAM_MEMBER_ID'),
    team_id     int,
    ctw_id      text,
    name        text,
    created_at  TIMESTAMP,
    modified_at TIMESTAMP,
    FOREIGN KEY (team_id) REFERENCES T_TEAM (id)
);
CREATE TABLE T_BOOKING
(
    id            int PRIMARY KEY DEFAULT nextval('SEQ_BOOKING_ID'),
    rack_id       int,
    requester_id  int,
    serial_number text,
    book_from     TIMESTAMP,
    book_to       TIMESTAMP,
    created_at    TIMESTAMP,
    modified_at   TIMESTAMP,
    FOREIGN KEY (requester_id) REFERENCES T_TEAM_MEMBER (id)
);

INSERT INTO T_TEAM (product, name, default_location)
VALUES ('Plant', 'The Gardeners', 'Lisbon');
INSERT INTO T_TEAM (product, name, default_location)
VALUES ('Car', 'Stars', 'Porto');
INSERT INTO T_TEAM (product, name, default_location)
VALUES ('Moto', 'Speedsters', 'Braga');
INSERT INTO T_TEAM (product, name, default_location)
VALUES ('Dashboards', 'The Analytics', 'Lisbon');
INSERT INTO T_TEAM (product, name, default_location)
VALUES ('Car', 'Wheels', 'Porto');
INSERT INTO T_TEAM (product, name, default_location)
VALUES ('Car', 'Sonic Team', 'Porto');

INSERT INTO T_RACK(id, serial_number, status, team_id, created_at, default_location, modified_at, assembled_at )
VALUES (DEFAULT, '1000-12021-01', 'BRICKED', 1,'2024-07-09 17:49:22.471747', 'PORTO', now(), now());
INSERT INTO T_RACK(id, serial_number, status, team_id, created_at, default_location, modified_at, assembled_at )
VALUES (DEFAULT, '1000-12021-02','OUTDATED', 2, '2024-02-01', 'PORTO', now(), now());
INSERT INTO T_RACK(id, serial_number, status, team_id, created_at, default_location, modified_at, assembled_at )
VALUES (DEFAULT, '2222-10000-01','REPAIR', 3, '2023-08-01', 'LISBON', now(), now());
INSERT INTO T_RACK(id, serial_number, status, team_id, created_at, default_location, modified_at, assembled_at )
VALUES (DEFAULT, '1000-12021-03', 'RETURNED',4, '2024-07-09 21:15:21.350827', 'BRAGA', now(), now());
INSERT INTO T_RACK(id, serial_number, status, team_id, created_at, default_location, modified_at, assembled_at )
VALUES (DEFAULT, '3100-11031-01','ACTIVE',5, '2024-07-09 21:54:38.432536', 'PORTO', now(), now());

INSERT INTO T_TEAM_MEMBER (team_id, ctw_id, name) VALUES(1,'CTW0001','João Pires');
INSERT INTO T_TEAM_MEMBER (team_id, ctw_id, name) VALUES(2,'CTW0002','Amália Rodrigues');
INSERT INTO T_TEAM_MEMBER (team_id, ctw_id, name) VALUES(3,'CTW0003','Alberto Meireles');
INSERT INTO T_TEAM_MEMBER (team_id, ctw_id, name) VALUES(4,'CTW0004','Ana Luísa');
INSERT INTO T_TEAM_MEMBER (team_id, ctw_id, name) VALUES(4,'CTW0005','António Costa');
INSERT INTO T_TEAM_MEMBER (team_id, ctw_id, name) VALUES(2,'CTW0006','Catarina Silva');

INSERT INTO T_RACK_ASSET (id, asset_tag, rack_id) VALUES (1,'tag1',1);
INSERT INTO T_RACK_ASSET (id, asset_tag, rack_id) VALUES (2,'tag2',2);
INSERT INTO T_RACK_ASSET (id, asset_tag, rack_id) VALUES (3,'tag3',3);
INSERT INTO T_RACK_ASSET (id, asset_tag, rack_id) VALUES (4,'tag4',4);

INSERT INTO T_BOOKING (rack_id, serial_number, requester_id, book_from, book_to, created_at, modified_at) VALUES (1, '1234',1, '2024-01-01','2024-01-25',now(),now());
INSERT INTO T_BOOKING (rack_id, serial_number, requester_id, book_from, book_to, created_at, modified_at) VALUES (2, '5678',2, '2024-07-01','2025-11-25',now(),now());
INSERT INTO T_BOOKING (rack_id, serial_number, requester_id, book_from, book_to, created_at, modified_at) VALUES (3, '9123',3, '2024-03-01','2024-05-15',now(),now());
INSERT INTO T_BOOKING (rack_id, serial_number, requester_id, book_from, book_to, created_at, modified_at) VALUES (4, '4567',4, '2024-01-01','2024-03-15',now(),now());
INSERT INTO T_BOOKING (rack_id, serial_number, requester_id, book_from, book_to, created_at, modified_at) VALUES (4, '8912',4, '2024-04-01','2024-04-30',now(),now());


