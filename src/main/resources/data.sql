INSERT INTO auditory VALUES(1,1);
INSERT INTO auditory VALUES(2,2);
INSERT INTO auditory VALUES(3,3);
INSERT INTO auditory VALUES(4,4);

INSERT INTO course VALUES(1,'Math');
INSERT INTO course VALUES(2,'Literature');
INSERT INTO course VALUES(3,'Geography');
INSERT INTO course VALUES(4,'Chemistry');

INSERT INTO department VALUES(1,'One');
INSERT INTO department VALUES(2,'Two');
INSERT INTO department VALUES(3,'Three');
INSERT INTO department VALUES(4,'Four');

INSERT INTO groupes VALUES(1,'One');
INSERT INTO groupes VALUES(2,'Two');
INSERT INTO groupes VALUES(3,'Three');
INSERT INTO groupes VALUES(4,'Four');

INSERT INTO lesson VALUES(1,'One');
INSERT INTO lesson VALUES(2,'Two');
INSERT INTO lesson VALUES(3,'Three');
INSERT INTO lesson VALUES(4,'Four');

INSERT INTO student(id, name, secondName, birthday, phoneid, email, password, status) VALUES (1,'John', 'Smith', TO_DATE('1983-03-07','yyyy-mm-dd'), 1,'1@mail.ru', '12345','Daily');
INSERT INTO student(id, name, secondName, birthday, phoneid, email, password, status) VALUES (2,'Alex', 'Merfi', TO_DATE('1983-03-07','yyyy-mm-dd'), 1,'2@mail.ru', '12345','Daily');
INSERT INTO student(id, name, secondName, birthday, phoneid, email, password, status) VALUES (3,'Pol', 'Crosby', TO_DATE('1983-03-07','yyyy-mm-dd'), 1,'3@mail.ru', '12345','Daily');
INSERT INTO student(id, name, secondName, birthday, phoneid, email, password, status) VALUES (4,'Cary', 'Price', TO_DATE('1983-03-07','yyyy-mm-dd'), 1,'4@mail.ru', '12345','Daily');

INSERT INTO phone(id, codeOfCountry, codeOfCity, phoneNumber, additionalNumber) VALUES(1,'+7', '812', '3334455', '0987');
INSERT INTO phone(id, codeOfCountry, codeOfCity, phoneNumber, additionalNumber) VALUES(2,'+7', '812', '3334455', '0987');
INSERT INTO phone(id, codeOfCountry, codeOfCity, phoneNumber, additionalNumber) VALUES(3,'+7', '812', '3334455', '0987');
INSERT INTO phone(id, codeOfCountry, codeOfCity, phoneNumber, additionalNumber) VALUES(4,'+7', '812', '3334455', '0987');

INSERT INTO teacher(id, name, secondName, birthday, phoneid, email, password, rank) VALUES (1,'Alex', 'Bloo', TO_DATE('1983-03-07','yyyy-mm-dd'), 1,'1@mail.ru', '12345','Professor');
INSERT INTO teacher(id, name, secondName, birthday, phoneid, email, password, rank) VALUES (2,'John', 'Cambel', TO_DATE('1983-03-07','yyyy-mm-dd'), 1,'2@mail.ru', '12345','Professor');
INSERT INTO teacher(id, name, secondName, birthday, phoneid, email, password, rank) VALUES (3,'Antony', 'Smith', TO_DATE('1983-03-07','yyyy-mm-dd'), 1,'3@mail.ru', '12345','Professor');
INSERT INTO teacher(id, name, secondName, birthday, phoneid, email, password, rank) VALUES (4,'Pol', 'Rassel', TO_DATE('1983-03-07','yyyy-mm-dd'), 1,'4@mail.ru', '12345','Professor');