-- how group by works 
-- Player 1
-- player_id	device_id	event_date	   games_played
-- 1	              2	     2016-03-01	      5
-- 1	              2	      2016-05-02	  6

-- Player 2
-- player_id	device_id	   event_date	    games_played
--       2	      3	            2017-06-25	    1

-- Player 3
-- player_id	   device_id	   event_date	 games_played
--       3	          1	       2016-03-02   	0
--       3	          4	       2018-07-03	    5

-- select player_id,MIN(event_date) as first_login 
-- from  Activity 
-- group by player_id

select player_id , event_date  as first_login 
from (
    select player_id , event_date ,
    ROW_NUMBER() OVER ( PARTITION  BY player_id order by event_date) as rn
    from Activity  
) t
where rn = 1