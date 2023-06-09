INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('123456789', 'John', 'Doe', 'admin@admin', 'admin', 'admin');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('987654321', 'Jane', 'Smith', 'jane.smith@example.com', 'password456', 'teacher');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('456789123', 'Michael', 'Johnson', 'michael.johnson@example.com', 'password789', 'teacher');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('321654987', 'Emily', 'Davis', 'emily.davis@example.com', 'passwordabc', 'teacher');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('654321987', 'Robert', 'Anderson', 'robert.anderson@example.com', 'passworddef', 'admin');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('789123456', 'Jessica', 'Wilson', 'jessica.wilson@example.com', 'passwordghi', 'student');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('852741963', 'David', 'Brown', 'david.brown@example.com', 'passwordjkl', 'student');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('369258147', 'Jennifer', 'Taylor', 'jennifer.taylor@example.com', 'passwordmno', 'admin');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('741852963', 'Daniel', 'Thomas', 'daniel.thomas@example.com', 'passwordpqr', 'user');
INSERT INTO users (dni, name, last_name, email, password, role) VALUES ('258369147', 'Sophia', 'Lee', 'sophia.lee@example.com', 'passwordstu', 'user');


INSERT INTO courses (name, description, capacity, teacher_id, classes_id, price, start_date, end_date, start_hour, end_hour) VALUES ('Curso 1', 'Descripción del curso 1', 20, 2, '1, 2, 3', 99.99, '2023-06-10', '2023-07-10', '09:00:00', '12:00:00');
INSERT INTO courses (name, description, capacity, teacher_id, classes_id, price, start_date, end_date, start_hour, end_hour) VALUES ('Curso 2', 'Descripción del curso 2', 30, 3, '4, 5, 6', 149.99, '2023-06-15', '2023-07-15', '13:00:00', '16:00:00');
INSERT INTO courses (name, description, capacity, teacher_id, classes_id, price, start_date, end_date, start_hour, end_hour) VALUES ('Curso 3', 'Descripción del curso 3', 15, 4, '7, 8, 9', 199.99, '2023-06-20', '2023-07-20', '10:00:00', '13:00:00');


INSERT INTO Inscriptions (course_id, student_id) VALUES (1, 1);
INSERT INTO Inscriptions (course_id, student_id) VALUES (2, 6);
INSERT INTO Inscriptions (course_id, student_id) VALUES (3, 7);
