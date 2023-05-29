SELECT
    YEAR(START_DATE)  "Рік",
    DATEPART(QUARTER, START_DATE)  "Квартал",
    COUNT(*) "Кількість замовлень" 
FROM
    ORDERS
GROUP BY
    YEAR(START_DATE),
    DATEPART(QUARTER, START_DATE)
ORDER BY
    YEAR(START_DATE),
    DATEPART(QUARTER, START_DATE);


GO



WITH QuarterlyOrders AS (
    SELECT
        YEAR(START_DATE)  "Рік",
        DATEPART(QUARTER, START_DATE) "Найпопулярніший квартал",
        COUNT(*) "Кількість замовлень" 
    FROM
        Orders
    GROUP BY
        YEAR(START_DATE),
        DATEPART(QUARTER, START_DATE)
)
SELECT
    "Рік",
    "Найпопулярніший квартал",
    "Кількість замовлень"
FROM
    QuarterlyOrders
WHERE
    "Кількість замовлень" > (
        SELECT
            AVG("Кількість замовлень")
        FROM
            QuarterlyOrders
    );