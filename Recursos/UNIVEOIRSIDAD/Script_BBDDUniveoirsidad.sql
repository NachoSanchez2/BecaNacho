CREATE TABLE userUniversity (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  dni VARCHAR(9) NOT NULL,
  surname VARCHAR(100) NOT NULL,
  mail VARCHAR(200) NOT NULL,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  tipoPersona INT NOT NULL,
  PRIMARY KEY (id, dni, username));
  
  INSERT INTO userUniversity (name, dni, surname, mail, username, password, tipoPersona) 
VALUES ('pepe', 'pepe', 'pepe', 'pepe', 'pepe', 'pepe', '1'),
	   ('maria', 'maria', 'maria', 'maria', 'maria', 'maria', '2'),
	   ('pablo', 'pablo', 'pablo', 'pablo', 'pablo', 'pablo', '2'),
       ('paco', 'paco', 'paco', 'paco', 'paco', 'paco', '1'),
	   ('esteban', 'esteban', 'esteban', 'esteban', 'esteban', 'esteban', '3'),
	   ('lucas', 'lucas', 'lucas', 'lucas', 'lucas', 'lucas', '3');
       
CREATE TABLE studentUniversity(
  id INT NOT NULL DEFAULT 1,
  faculty VARCHAR(100) NOT NULL,
  idUser INT,
  PRIMARY KEY (id),
	CONSTRAINT F_studentUniversity
	FOREIGN KEY (idUser)
	REFERENCES useruniversity (id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION);
    
INSERT INTO studentUniversity (faculty,idUser) VALUES ('Informatica',1);
INSERT INTO studentUniversity (faculty) VALUES ('Telecomunicaciones');
INSERT INTO studentUniversity (faculty) VALUES ('Economia');
INSERT INTO studentUniversity (faculty,idUser) VALUES ('Diseño',4);

  CREATE TABLE professorUniversity(
  id INT NOT NULL AUTO_INCREMENT,
  office VARCHAR(100) NOT NULL,
  idUser INT,
  PRIMARY KEY (id),
  CONSTRAINT F_professorUniversity
	FOREIGN KEY (idUser)
	REFERENCES useruniversity (id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION);
INSERT INTO professorUniversity (office,idUser) VALUES ('AEU012',2);
INSERT INTO professorUniversity (office,idUser) VALUES('ADO123',3);
INSERT INTO professorUniversity (office) VALUES('LIJ120');
INSERT INTO professorUniversity (office) VALUES('ÑOK220');

  CREATE TABLE pasUniversity (
  id INT NOT NULL AUTO_INCREMENT,
  unit VARCHAR(30) NOT NULL,
  idUser INT,
  PRIMARY KEY (id),
  	CONSTRAINT F_pasUniversity
	FOREIGN KEY (idUser)
	REFERENCES useruniversity (id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION);
    
INSERT INTO pasUniversity (unit,idUser) VALUES ('Administracion',5);
INSERT INTO pasUniversity (unit) VALUES ('Servicios');
INSERT INTO pasUniversity (unit) VALUES ('Jardineria');
INSERT INTO pasUniversity (unit,idUser) VALUES ('Secretarios',6);