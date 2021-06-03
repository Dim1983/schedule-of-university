DROP TABLE IF EXISTS auditory;

CREATE TABLE IF NOT EXISTS auditory (
    id SERIAL,
    number INTEGER NOT NULL
);

DROP TABLE IF EXISTS course;

CREATE TABLE IF NOT EXISTS course (
    id SERIAL,
    name VARCHAR (254) NOT NULL
);

DROP TABLE IF EXISTS department;

CREATE TABLE IF NOT EXISTS department (
    id SERIAL,
    name VARCHAR (254) NOT NULL
);

DROP TABLE IF EXISTS groupes;

CREATE TABLE IF NOT EXISTS groupes (
    id SERIAL,
    name VARCHAR (254) NOT NULL
);

DROP TABLE IF EXISTS lesson;

CREATE TABLE IF NOT EXISTS lesson (
    id SERIAL,
    name VARCHAR (254) NOT NULL
);

DROP TABLE IF EXISTS phone;

CREATE TABLE IF NOT EXISTS phone
(
    id SERIAL PRIMARY KEY,
    codeofcountry VARCHAR(254),
    codeofcity VARCHAR(254),
    phonenumber VARCHAR(254),
    additionalnumber VARCHAR(254)
);

DROP TABLE IF EXISTS student;

CREATE TABLE IF NOT EXISTS student
(
    id SERIAL PRIMARY KEY,
    name VARCHAR (254),
    secondName VARCHAR (254),
    birthday date NOT NULL,
    phoneid INTEGER NOT NULL,
    email VARCHAR (254),
    password VARCHAR (254),
    status VARCHAR (254)
);

DROP TABLE IF EXISTS teacher;

CREATE TABLE IF NOT EXISTS teacher
(
    id SERIAL PRIMARY KEY,
    name VARCHAR (254),
    secondName VARCHAR (254),
    birthday date NOT NULL,
    phoneid INTEGER NOT NULL,
    email VARCHAR (254),
    password VARCHAR (254),
    rank VARCHAR (254)
);
