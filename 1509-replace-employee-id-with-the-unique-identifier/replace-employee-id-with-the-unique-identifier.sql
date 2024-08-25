-- Write your PostgreSQL query statement below

SELECT unique_id,name
from Employees
LEFT JOIN EmployeeUNI
ON EmployeeUNI.id = Employees.id;
