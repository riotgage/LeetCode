-- Write your PostgreSQL query statement below
SELECT query_name,
        ROUND(SUM(rating::numeric/position)/COUNT(rating),2) as quality,
        ROUND(100. * COUNT(rating) FILTER (WHERE rating<3)/COUNT(rating),2) as poor_query_percentage 
FROM Queries
WHERE query_name is NOT NULL
GROUP BY query_name