SELECT E1.name
FROM Employee E1 
Where E1.id in 
(SELECT managerId
From Employee
GROUP BY managerId
HAVING COUNT(*) >=5);