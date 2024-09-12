-- Write your PostgreSQL query statement below
SELECT contest_id,(ROUND((COUNT(user_id) * 100.0 / (Select COUNT(*) from users)),2)) as percentage
FROM Register 
GROUP BY contest_id
ORDER BY percentage DESC, contest_id;