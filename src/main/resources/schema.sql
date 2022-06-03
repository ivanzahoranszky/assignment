CREATE TABLE phone
(
    id          INT AUTO_INCREMENT,
    device_name CHARACTER VARYING(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE puser
(
    id   INT AUTO_INCREMENT,
    name CHARACTER VARYING(50) NOT NULL UNIQUE ,
    PRIMARY KEY (id)
);

CREATE TABLE booking
(
    id      INT AUTO_INCREMENT,
    phone   INT NOT NULL UNIQUE ,
    puser   INT NOT NULL,
    started TIMESTAMP NOT NULL,
    ended   TIMESTAMP,
    FOREIGN KEY (phone) REFERENCES phone (id),
    FOREIGN KEY (puser) REFERENCES puser (id)
);

INSERT INTO phone (device_name) VALUES ('Samsung Galaxy S9');
INSERT INTO phone (device_name) VALUES ('2x Samsung Galaxy S8');
INSERT INTO phone (device_name) VALUES ('Motorola Nexus 6');
INSERT INTO phone (device_name) VALUES ('Oneplus 9');
INSERT INTO phone (device_name) VALUES ('Apple iPhone 13');
INSERT INTO phone (device_name) VALUES ('Apple iPhone 12');
INSERT INTO phone (device_name) VALUES ('Apple iPhone 11');
INSERT INTO phone (device_name) VALUES ('iPhone X');
INSERT INTO phone (device_name) VALUES ('Nokia 3310');

INSERT INTO puser (name) VALUES ('Joe');
INSERT INTO puser (name) VALUES ('Sue');
INSERT INTO puser (name) VALUES ('Kate');
INSERT INTO puser (name) VALUES ('Ivan');