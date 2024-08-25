-- Write your PostgreSQL query statement below
select a.id from weather a
where a.temperature > (select b.temperature from weather b where b.recorddate=a.recorddate-1)