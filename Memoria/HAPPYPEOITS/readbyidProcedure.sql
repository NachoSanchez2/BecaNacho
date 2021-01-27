CREATE DEFINER=`root`@`localhost` PROCEDURE `readByID`(id int)
BEGIN
	DECLARE typepet INT;
    SET typepet = (SELECT readbyid(id));
	IF typepet = 1 THEN 
		SELECT p.name,p.location,p.description,p.typePet,p.photo,ow.ownername,ow.tlf,d.age
        FROM pet p
        LEFT JOIN owner ow ON p.id = ow.idpet
        LEFT JOIN dog d ON p.id = d.idpet
        WHERE p.id = id;
	ELSEIF typepet = 2 THEN
		SELECT p.name,p.location,p.description,p.typePet,p.photo,ow.ownername,ow.tlf,c.age
        FROM pet p 
        LEFT JOIN owner ow ON p.id = ow.idpet
        LEFT JOIN cat c ON p.id = c.idpet
        WHERE p.id = id;
	ELSEIF typepet = 3 THEN 
		SELECT p.name,p.location,p.description,p.typePet,p.photo,ow.ownername,ow.tlf,b.colour
        FROM pet p 
        LEFT JOIN owner ow ON p.id = ow.idpet
        LEFT JOIN bird b ON p.id = b.idpet
        WHERE p.id = id;
	ELSE
		SELECT p.name,p.location,p.description,p.typePet,p.photo,ow.ownername,ow.tlf,o.type
        FROM pet p 
        LEFT JOIN owner ow ON p.id = ow.idpet
        LEFT JOIN other o ON p.id = o.idpet
        WHERE p.id = id;
	END IF;
END