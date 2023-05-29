
SELECT
    B.CODE,
    B.SIZE,
    B.Price,
    COUNT(*) "Кількість бронювань"
FROM
    BOXES B
JOIN
    Orders O ON B.ID = O.BOXID
GROUP BY
    B.ID,
    B.CODE,
    B.SIZE,
    B.Price
    
ORDER BY
    COUNT(*) DESC;