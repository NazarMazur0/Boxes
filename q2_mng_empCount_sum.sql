USE Boxes
SELECT E.ID, M.NAME +' '+ M.SURNAME "Менеджер", SUM(O.[SUM]) "Виручка", COUNT(E.ID) "Кількість підлеглих", Sum( O.SUM)/COUNT(E.ID) "виручка на підлеглого"
FROM EMPLOYEE M JOIN EMPLOYEE E on E.ManagerID=M.ID JOIN ORDERS O on O.EMLOYEEID = E.ID
GROUP BY M.NAME , M.SURNAME, E.ID