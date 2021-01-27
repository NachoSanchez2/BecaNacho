CREATE TABLE translate (
  id INT NOT NULL AUTO_INCREMENT,
  english VARCHAR(100) NULL,
  spanish VARCHAR(100) NULL,
  PRIMARY KEY (id));

CREATE TABLE jokes (
id INT NOT NULL AUTO_INCREMENT,
joke VARCHAR(600) NULL,
PRIMARY KEY (id));

INSERT INTO jokes (joke) 
VALUES ('Tokofondo. ¿Y el subcampeón?. Kasitoko.'),
('En una entrevista de trabajo: - ¿Nivel de inglés? - Alto - Bien. Traduzca "fiesta". - Party - Perfecto. Úselo en una frase. - Ayer me party la cara con la bicicleta. - Contratado.'),
('- ¿Nivel de inglés? - Alto. - Diga “memoria”. - Memory. - Póngalo en una frase. - Salté por una ventana y memory. - Contratado.'),
('- ¡Sí, mi capitán!- No lo vi ayer en la prueba de camuflaje.- ¡Gracias, mi capitán!'),
('- Mamá, mamá, el abuelo se cayó - ¿Lo ayudaste hijo? - No, se cayó solo.');

INSERT INTO translate (english,spanish) 
VALUES ('music','musica'),
('cat','gato'),
('dogg','perro'),
('translate','traducir'),
('scorpion','escorpion'),
('chord','acorde'),
('conformidad','accordance'),
('snake','serpiente'),
('comma','coma'),
('lizard','lagartija'),
('bat','murcielago'),
('man','hombre'),
('mujer','mujer'),
('bot','larva del moscardon'),
('tail','cola'),
('computer','computadora'),
('calculator','calculadora'),
('mosquito','mosquito'),
('fly','mosca'),
('worm','lombriz');