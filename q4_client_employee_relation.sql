SELECT C.NAME AS "Ім'я клієнта", C.SURNAME AS "Прізвище клієнта", C.Phone AS "Телефон кілєнта", E.NAME "Ім'я працівника",E.SURNAME "Прізвище працівника", E.PHONE "Телефон працівника"
FROM CLIENTS C, EMPLOYEE E
WHERE C.ID IN (
  SELECT CLIENTID
  FROM ORDERS
  WHERE EMLOYEEID=E.ID
)
