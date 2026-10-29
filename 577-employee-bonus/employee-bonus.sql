# Write your MySQL query statement below
-- select name , bonus
-- from Employee e
-- left join  Bonus b
-- on  e.empId = b.empId 
-- where b.bonus is null or b.bonus < 1000;

SELECT e.name, b.bonus
FROM Employee e
LEFT JOIN Bonus b ON e.empId = b.empId
WHERE COALESCE(b.bonus, 0) < 1000;

