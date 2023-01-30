INSERT INTO users (name,email,password) VALUES ('Nina','nina@gmail.com','$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO users (name,email,password) VALUES ('Nino','nino@gmail.com','$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');

INSERT INTO roles (role_name) VALUES ('OPERATOR');
INSERT INTO roles (role_name) VALUES ('ADMIN');

INSERT INTO users_roles (user_id,role_id) VALUES (1,1);
INSERT INTO users_roles (user_id,role_id) VALUES (2,1);
INSERT INTO users_roles (user_id,role_id) VALUES (2,2);