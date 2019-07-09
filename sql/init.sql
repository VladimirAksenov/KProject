/*Не используется более или переделана, но когда-то было вот так. Вся структура (table, constraints и тд ) в KProject/src/main/java/com/example/Kproject/model */
CREATE TABLE U_Groups
(
    id         INT PRIMARY KEY NOT NULL,
    max_amount INT             NOT NULL CHECK (max_amount < 25),
    name       VARCHAR(25)
);

CREATE TABLE U_Students
(
    id      INT PRIMARY KEY NOT NULL,
    name    VARCHAR(50),
    surname VARCHAR(50),
    group_id        INT REFERENCES U_Groups (id)
);

CREATE TABLE U_Departments
(
    id    INT PRIMARY KEY NOT NULL,
    name  VARCHAR(25),
    floor INT
);

CREATE TABLE U_Teachers
(
    id      INT PRIMARY KEY NOT NULL,
    name    VARCHAR(50),
    surname VARCHAR(50),
    department_id   INT REFERENCES U_Departments (id)
);

CREATE TABLE U_Lessons
(
    id   INT PRIMARY KEY NOT NULL,
    name VARCHAR(50)
);

CREATE TABLE U_Schedule
(
    id INT PRIMARY KEY NOT NULL,
    group_id  INT REFERENCES U_Groups(id),
    teacher_id INT REFERENCES U_Teachers(id),
    lesson_id INT REFERENCES U_Lessons(id),
    time VARCHAR (25)
);