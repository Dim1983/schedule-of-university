CREATE TABLE IF NOT EXISTS auditory
(
    id SERIAL PRIMARY KEY,
    number INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS course
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(254) NOT NULL
);

CREATE TABLE IF NOT EXISTS department
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(254) NOT NULL
);

CREATE TABLE IF NOT EXISTS groupes
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(254) NOT NULL
);

CREATE TABLE IF NOT EXISTS lesson
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(254) NOT NULL
);

CREATE TABLE IF NOT EXISTS phone
(
    id SERIAL PRIMARY KEY,
    codeOfCountry VARCHAR(254),
    codeOfCity VARCHAR(254),
    phoneNumber VARCHAR(254),
    additionalNumber VARCHAR(254)
);

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
