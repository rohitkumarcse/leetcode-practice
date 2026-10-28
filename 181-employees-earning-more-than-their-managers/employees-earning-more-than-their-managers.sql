select name as Employee 
from  Employee as e
where e.salary > (select salary from Employee as m  where e.managerId = m.id )