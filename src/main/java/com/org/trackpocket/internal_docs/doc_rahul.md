
Stop/kill a port
```
kill -9 $(lsof -t -i :8080)
```

```mysql
CREATE DATABASE IF NOT EXISTS pfa;
USE pfa;
CREATE TABLE IF NOT EXISTS student
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    first_name   VARCHAR(50) NOT NULL,
    last_name    VARCHAR(50) NOT NULL,
    phone_number VARCHAR(15),
    email        VARCHAR(100),
    address      VARCHAR(255)
);

INSERT INTO student (first_name, last_name, phone_number, email, address)
VALUES ('John', 'Doe', '555-1234', 'john.doe@example.com', '123 Maple Street'),
       ('Jane', 'Smith', '555-5678', 'jane.smith@example.com', '456 Oak Avenue'),
       ('Michael', 'Brown', '555-8765', 'michael.brown@example.com', '789 Pine Road'),
       ('Emily', 'Johnson', '555-4321', 'emily.johnson@example.com', '101 Cedar Lane'),
       ('David', 'Lee', '555-2345', 'david.lee@example.com', '202 Birch Boulevard'),
       ('Sarah', 'Miller', '555-6789', 'sarah.miller@example.com', '303 Spruce Drive'),
       ('Daniel', 'Wilson', '555-3456', 'daniel.wilson@example.com', '404 Elm Street'),
       ('Sophia', 'Davis', '555-9876', 'sophia.davis@example.com', '505 Ash Court'),
       ('Matthew', 'Garcia', '555-5432', 'matthew.garcia@example.com', '606 Redwood Avenue'),
       ('Olivia', 'Martinez', '555-7890', 'olivia.martinez@example.com', '707 Cherry Street');

select * from student;
```