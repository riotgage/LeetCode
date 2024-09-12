-- Write your PostgreSQL query statement below
WITH total_users AS (
    SELECT COUNT(*) AS user_count
    FROM Users
)
SELECT
    r.contest_id,
    ROUND(COUNT(r.user_id) * 100.0 / tu.user_count, 2) AS percentage
FROM
    Register r
CROSS JOIN
    total_users tu
GROUP BY 1, tu.user_count
ORDER BY 2 DESC, 1 ASC;