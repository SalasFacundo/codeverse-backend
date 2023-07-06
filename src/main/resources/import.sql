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


INSERT INTO courses (name, description, capacity, teacher_id, price, start_date, end_date, start_hour, end_hour) VALUES ('HTML y CSS', 'Descripción del curso 1', 20, 2, 999, '2023-06-10', '2023-07-10', '09:00:00', '12:00:00');
INSERT INTO courses (name, description, capacity, teacher_id, price, start_date, end_date, start_hour, end_hour) VALUES ('Introduccion a python', 'Descripción del curso 2', 30, 3, 149, '2023-06-15', '2023-07-15', '13:00:00', '16:00:00');
INSERT INTO courses (name, description, capacity, teacher_id, price, start_date, end_date, start_hour, end_hour) VALUES ('Robotica', 'Descripción del curso 3', 15, 4, 199, '2023-06-20', '2023-07-20', '10:00:00', '13:00:00');


INSERT INTO Inscriptions (course_id, student_id) VALUES (1, 2);
INSERT INTO Inscriptions (course_id, student_id) VALUES (2, 3);
INSERT INTO Inscriptions (course_id, student_id) VALUES (3, 6);
INSERT INTO Inscriptions (course_id, student_id) VALUES (1, 3);
INSERT INTO Inscriptions (course_id, student_id) VALUES (2, 6);
INSERT INTO Inscriptions (course_id, student_id) VALUES (3, 4);
INSERT INTO Inscriptions (course_id, student_id) VALUES (1, 9);
INSERT INTO Inscriptions (course_id, student_id) VALUES (2, 8);
INSERT INTO Inscriptions (course_id, student_id) VALUES (3, 7);


INSERT INTO clases (course_id, number_class, name, description) VALUES (1, '1', "Clase 1: Introducción a HTML", "En esta clase se presentará HTML y su estructura básica, incluyendo las etiquetas, los elementos y los atributos. También se mostrará cómo crear una página HTML básica y cómo visualizarla en un navegador web.");
INSERT INTO clases (course_id, number_class, name, description) VALUES (1, '2', "Clase 2: Introducción a CSS", "En esta clase se presentará CSS y cómo se utiliza para dar estilo y diseño a las páginas web. Se discutirán los diferentes tipos de selectores, la cascada y la herencia, y se mostrará cómo aplicar estilos básicos a una página HTML.");
INSERT INTO clases (course_id, number_class, name, description) VALUES (1, '3', "Clase 3: Diseño de páginas web con CSS", "En esta clase se explicará cómo diseñar páginas web más complejas utilizando CSS, incluyendo el diseño de cajas, el posicionamiento de elementos y la creación de diseños responsivos para diferentes dispositivos.");


INSERT INTO clases (course_id, number_class, name, description) VALUES (2, '1', "Clase 1: Introducción a Python", "En esta clase se presentará el lenguaje de programación Python, sus características y beneficios. También se mostrará cómo instalar Python y configurar el entorno de trabajo.");
INSERT INTO clases (course_id, number_class, name, description) VALUES (2, '2', "Clase 2: Variables y tipos de datos", "En esta clase se enseñará cómo crear y manipular variables en Python, y se presentarán los diferentes tipos de datos básicos como números, cadenas de texto y booleanos.");
INSERT INTO clases (course_id, number_class, name, description) VALUES (2, '3', "Clase 3: Estructuras de control de flujo", " En esta clase se explicará cómo controlar el flujo de ejecución de un programa en Python utilizando estructuras como if-else, while, for y try-except.");

INSERT INTO clases (course_id, number_class, name, description) VALUES (3, '1', "Clase 1: Introducción a la robótica", "En esta clase se presentará una introducción general a la robótica, sus aplicaciones y los diferentes tipos de robots que existen.");
INSERT INTO clases (course_id, number_class, name, description) VALUES (3, '2', "Clase 2: Diseño y construcción de robots", " En esta clase se enseñará cómo diseñar y construir robots desde cero, incluyendo la selección de materiales, la elección de componentes y la integración de hardware y software.");
INSERT INTO clases (course_id, number_class, name, description) VALUES (3, '3', "Clase 3: Control y programación de robots", "En esta clase se discutirán los fundamentos del control y la programación de robots, incluyendo la programación de microcontroladores, la programación de robots con ROS (Robot Operating System) y la integración de sensores y actuadores.");
