DELETE p
FROM Person AS p
JOIN Person AS d
    ON p.email = d.email
WHERE p.id > d.id;