CREATE DEFINER=`root`@`localhost` PROCEDURE `uploadbyid`(
id INT,
newname VARCHAR(100),
newlocation VARCHAR(100),
newdescription VARCHAR(100),
newphoto VARCHAR(200),
newownername VARCHAR(100),
newownertlf VARCHAR(100),
newage INT,
newcolour VARCHAR(60),
newtype VARCHAR(100))
BEGIN
	DECLARE typepet INT;
    SET typepet = readbyid(id);
	IF typepet = 1 THEN 
		UPDATE pet p
        JOIN owner ow ON p.id = ow.idpet
        JOIN dog d ON p.id = d.idpet
        SET p.name = newname,p.location = newlocation,p.description=newdescription,p.photo = newphoto,ow.name= newownername,ow.tlf=newownertlf,d.age=newage
        WHERE p.id = id;
	ELSEIF typepet = 2 THEN
		UPDATE pet p
        JOIN owner ow ON p.id = ow.idpet
        JOIN cat c ON p.id = c.idpet
        SET p.name = newname,p.location = newlocation,p.description=newdescription,p.photo = newphoto,ow.name= newownername,ow.tlf=newownertlf,c.age=newage
        WHERE p.id = id;
	ELSEIF typepet = 3 THEN 
		UPDATE pet p
        JOIN owner ow ON p.id = ow.idpet
        JOIN bird b ON p.id = b.idpet
        SET p.name = newname,p.location = newlocation,p.description=newdescription,p.photo = newphoto,ow.name= newownername,ow.tlf=newownertlf,b.colour=newcolour
        WHERE p.id = id;
	ELSE
		UPDATE pet p
        JOIN owner ow ON p.id = ow.idpet
        JOIN other o ON p.id = o.idpet
        SET p.name = newname,p.location = newlocation,p.description=newdescription,p.photo = newphoto,ow.name= newownername,ow.tlf=newownertlf,o.type=newtype
        WHERE p.id = id;
	END IF;
END