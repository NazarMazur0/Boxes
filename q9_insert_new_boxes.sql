USE Boxes
GO
DECLARE @smallCode nvarchar(10);
DECLARE @smallCount int;
DECLARE @smallPrice int;
DECLARE @mediumCount int;
DECLARE @mediumPrice int
DECLARE @mediumCode nvarchar(10);;
DECLARE @largeCount int;
DECLARE @largePrice int;
DECLARE @largeCode nvarchar(10);
DECLARE @boxesCount int;
DECLARE @locationAdress nchar(100);
DECLARE @locationID int;

SET @smallCode = 'АМ'
SET @smallCount = 25

SET @mediumCount = 15
SET @mediumCode = 'АС'

SET @largeCount = 10
SET @largeCode = 'АВ'

SET @smallPrice = 400
SET @mediumPrice = 600
SET @largePrice = 950
SET @locationAdress = 'м.Львів , вул. Артура Конан Дойля 178'
SET @boxesCount=@smallCount+@mediumCount+@largeCount
DECLARE @currentID int;


DECLARE @counter INT =1;
SET @locationID=(SELECT MAX(ID) + 1 FROM Locations)
INSERT INTO Locations VALUES ( @locationID,@boxesCount,@locationAdress)

    
WHILE @counter <= @smallCount 
BEGIN
    SET @currentID= (SELECT MAX(ID) + 1 FROM BOXES)
    INSERT INTO BOXES VALUES (@currentID ,CONCAT(@smallCode,@counter) ,'малий',0,@smallPrice,@locationID)
    SET @counter = @counter + 1;
END
SET @counter=1
WHILE @counter <= @mediumCount 
BEGIN
      SET @currentID= (SELECT MAX(ID) + 1 FROM BOXES)
    INSERT INTO BOXES VALUES (@currentID,CONCAT(@mediumCode,@counter ),'середній',0,@mediumPrice,@locationID)
    SET @counter = @counter + 1;
END
SET @counter=1
WHILE @counter <= @largeCount 
BEGIN
      SET @currentID= (SELECT MAX(ID) + 1 FROM BOXES)
    INSERT INTO BOXES VALUES (@currentID,CONCAT(@largeCode,@counter )  ,'великий',0,@mediumPrice,@locationID)
    SET @counter = @counter + 1;
END
