INSERT INTO T_CARETAKER (address, age, name, `PASSWORD`, sex, username) VALUES ('Str Lunga', 40, 'Care Giver', '12345', 'M', 'C');

INSERT INTO T_PATIENT (address, age, name, `PASSWORD`, sex, username) VALUES ('Str Lunga', 70, 'Care Receiver', '1234', 'M', 'P');

INSERT INTO T_PATIENT_T_CARETAKER (patients_id, caretakers_id) VALUES (1, 1);

INSERT INTO T_LOCATION (latitude, longitude, patient_id, `TIMESTAMP`) VALUES ('25', '45', 1, 12345);

INSERT INTO T_LOCATION (latitude, longitude, patient_id, `TIMESTAMP`) VALUES ('22', '20', 1, 234567);

INSERT INTO T_LOCATION (latitude, longitude, patient_id, `TIMESTAMP`) VALUES ('21', '66', 1, 2132512351);
