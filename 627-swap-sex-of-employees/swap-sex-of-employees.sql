# Write your MySQL query statement below
-- UPDATE Employee
-- SET salary = 50000,
--     name = 'Rahul'
-- WHERE id = 1;

UPDATE Salary
SET sex = CASE
    WHEN sex = 'm' THEN 'f'
    WHEN sex = 'f' THEN 'm'
END;
