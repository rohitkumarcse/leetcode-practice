-- DELETE p
-- FROM Person AS p
-- JOIN Person AS d
--     ON p.email = d.email
-- WHERE p.id > d.id;

delete p
from Person as p
where Id NOT IN  (
    select minId
     from (
        select MIN(id) as minId from Person group by email
     ) t
)