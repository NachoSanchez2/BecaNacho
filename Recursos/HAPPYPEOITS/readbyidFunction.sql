CREATE DEFINER=`root`@`localhost` FUNCTION `readbyid`(id INT) RETURNS int
    DETERMINISTIC
BEGIN
	DECLARE typepet INT;
    SET typepet =  (SELECT p.typepet FROM pet p WHERE p.id = id);
RETURN typepet;
END