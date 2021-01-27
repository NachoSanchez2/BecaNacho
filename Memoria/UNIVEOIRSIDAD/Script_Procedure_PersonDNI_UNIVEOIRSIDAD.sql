CREATE DEFINER=`root`@`localhost` PROCEDURE `readbyDNI`(tipoPersona INT,dni VARCHAR(9))
BEGIN   
	IF tipoPersona = 1 THEN
		SELECT u.id,u.name,u.dni, u.surname, u.username, u.password, u.mail, s.faculty, s.idUser 
        FROM useruniversity u 
        JOIN studentuniversity s ON u.id = s.idUser
        WHERE u.dni = dni;
	ELSEIF tipoPersona = 2 THEN 
		SELECT u.id,u.name,u.dni, u.surname, u.username, u.password, u.mail, p.office, p.idUser 
        FROM useruniversity u 
        JOIN professoruniversity p ON u.id = p.idUser
        WHERE u.dni = dni;
	ELSEIF tipoPersona = 3 THEN
		SELECT u.id,u.name,u.dni, u.surname, u.username, u.password, u.mail, pa.unit, pa.idUser
        FROM useruniversity u 
        JOIN pasuniversity pa ON u.id = pa.idUser
        WHERE u.dni = dni;
	END IF;
END