-- Write your PostgreSQL query statement below

SELECT p.product_id,

ROUND
(
    COALESCE( 
            SUM(
                p.price*COALESCE(u.units,0))
                /NULLIF(SUM(u.units),0)::numeric,0 ),2) 

as average_price 
FROM PRICES p
LEFT JOIN 
UnitsSold u
ON p.product_id = u.product_id 
AND 
u.purchase_date BETWEEN p.start_date
AND  p.end_date
GROUP BY p.product_id;
       
