-- Write your PostgreSQL query statement below
select tweet_id 
from Tweets
Where char_length(content) > 15; 