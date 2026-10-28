

-- select name as Employee 
-- from  Employee as e
-- where e.salary > (select salary from Employee as m  where e.managerId = m.id )




SELECT e.name AS Employee
FROM Employee AS e
JOIN Employee AS m
    ON e.managerId = m.id
WHERE e.salary > m.salary;

