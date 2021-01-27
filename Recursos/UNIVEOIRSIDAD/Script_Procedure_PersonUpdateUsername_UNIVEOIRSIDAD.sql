CREATE DEFINER=`root`@`localhost` PROCEDURE `updatebyUsername`(
tipoPersona INT, 
username VARCHAR(9),
name VARCHAR(100),
surname VARCHAR(100),
mail VARCHAR(200),
password VARCHAR(100),
faculty VARCHAR(100),
office VARCHAR(100),
unit VARCHAR(100)
)
BEGIN
IF tipoPersona = 1 THEN
	UPDATE useruniversity u
	JOIN studentuniversity s ON u.id = s.idUser
	SET u.name = name, u.surname = surname, u.mail = mail, u.password = password , s.faculty = faculty
	WHERE u.username = username;
ELSEIF tipoPersona = 2 THEN
	UPDATE useruniversity u
	JOIN professor p ON u.id = p.idUser
	SET u.name = name, u.surname = surname, u.mail = mail, u.password = password , p.office = office
	WHERE u.username = username;
ELSEIF tipoPersona = 3 THEN
	UPDATE useruniversity u
	JOIN pasuniversity pa ON u.id = pa.idUser
	SET u.name = name, u.surname = surname, u.mail = mail, u.password = password , pa.unit = unit
	WHERE u.username = username;
END IF;
END