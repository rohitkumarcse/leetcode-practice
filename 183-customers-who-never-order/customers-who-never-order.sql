-- Approach - 1 --
-- select name as Customers 
-- from Customers as c 
-- left join Orders as o 
-- on c.id  = o.customerId 
-- where customerId  is null;

 

SELECT c.name AS Customers
FROM Customers AS c
WHERE NOT EXISTS (
    SELECT 1
    FROM Orders AS o
    WHERE o.customerId = c.id
);