CREATE DEFINER=`root`@`localhost` PROCEDURE `readbyDNI`(dni VARCHAR(9))
BEGIN
	DECLARE tipoPersona INT;
    
	SELECT u.tipoPersona = tipoPersona
    FROM useruniversity u
    WHERE u.dni = dni;
    
	IF tipoPersona = 1 THEN
		SELECT u.name, u.username, u.dni, u.mail, s.faculty 
        FROM useruniversity u 
        JOIN studentuniversity s ON u.id = s.idUser;
	ELSEIF tipoPersona = 2 THEN 
		SELECT u.name, u.username, u.dni, u.mail, p.office 
        FROM useruniversity u 
        JOIN professoruniversity p ON u.id = p.idUser;
	ELSEIF tipoPersona = 3 THEN
		SELECT u.name, u.username, u.dni, u.mail, pa.unit 
        FROM useruniversity u 
        JOIN pasuniversity pa ON u.id = pa.idUser;
	END IF;
END