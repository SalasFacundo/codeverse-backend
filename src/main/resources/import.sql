INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('12345678', 'John', 'Doe', 'admin@admin', 'admin', 'admin');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('98765432', 'Jane', 'Smith', 'jane.smith@example.com', 'password456', 'teacher');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('45678912', 'Michael', 'Johnson', 'michael.johnson@example.com', 'password789', 'teacher');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('32165498', 'Emily', 'Davis', 'emily.davis@example.com', 'passwordabc', 'teacher');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('65432198', 'Robert', 'Anderson', 'robert.anderson@example.com', 'passworddef', 'admin');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('78912345', 'Jessica', 'Wilson', 'student@student', 'student', 'student');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('85274196', 'David', 'Brown', 'david.brown@example.com', 'passwordjkl', 'student');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('36925814', 'Jennifer', 'Taylor', 'jennifer.taylor@example.com', 'passwordmno', 'admin');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('74185296', 'Daniel', 'Thomas', 'daniel.thomas@example.com', 'passwordpqr', 'user');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('25836914', 'Sophia', 'Lee', 'sophia.lee@example.com', 'passwordstu', 'user');


INSERT INTO courses (name, description, capacity, teacher_id, classes_id, price, start_date, end_date, start_hour, end_hour) VALUES ('Programacion con Java', 'Descripción del curso 1', 20, 2, '1, 2, 3', 999, '2023-06-10', '2023-07-10', '09:00:00', '12:00:00');
INSERT INTO courses (name, description, capacity, teacher_id, classes_id, price, start_date, end_date, start_hour, end_hour) VALUES ('Introduccion a python', 'Descripción del curso 2', 30, 3, '4, 5, 6', 149, '2023-06-15', '2023-07-15', '13:00:00', '16:00:00');
INSERT INTO courses (name, description, capacity, teacher_id, classes_id, price, start_date, end_date, start_hour, end_hour) VALUES ('Arduino', 'Descripción del curso 3', 15, 4, '7, 8, 9', 199, '2023-06-20', '2023-07-20', '10:00:00', '13:00:00');


INSERT INTO Inscriptions (course_id, student_id) VALUES (1, 2);
INSERT INTO Inscriptions (course_id, student_id) VALUES (2, 3);
INSERT INTO Inscriptions (course_id, student_id) VALUES (3, 6);
INSERT INTO Inscriptions (course_id, student_id) VALUES (1, 3);
INSERT INTO Inscriptions (course_id, student_id) VALUES (2, 6);
INSERT INTO Inscriptions (course_id, student_id) VALUES (3, 4);
INSERT INTO Inscriptions (course_id, student_id) VALUES (1, 9);
INSERT INTO Inscriptions (course_id, student_id) VALUES (2, 8);
INSERT INTO Inscriptions (course_id, student_id) VALUES (3, 7);
