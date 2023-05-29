USE Boxes
GO
SELECT E.ID as "Employee ID",E.NAME "Ім'я",E.SURNAME "Прізвище", SUM(O.[SUM])  "Загальна сума всіх замовленнь"
FROM EMPLOYEE E JOIN  ORDERS O on O.EMLOYEEID=E.ID
Where E.ID = 4 
GROUP BY E.ID,E.NAME,E.SURNAME