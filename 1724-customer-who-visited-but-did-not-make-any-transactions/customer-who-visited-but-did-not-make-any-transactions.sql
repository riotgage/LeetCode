-- Write your PostgreSQL query statement below
SELECT Visits.customer_id,COUNT(*) as count_no_trans
FROM Visits
LEFT JOIN Transactions
ON Visits.visit_id = Transactions.visit_id
Where transaction_id IS null
GROUP BY customer_id;