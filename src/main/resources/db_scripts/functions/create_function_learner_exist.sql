create or replace function
	learner_exist(the_learner_email text)
	returns boolean as
	
$$
declare

total int;

begin

	select into total count(*) from learner 
		where LOWER(email) = LOWER(the_learner_email);
		
		if(total=1) then
			return true;
			
		else
			return false;
			
		end if;
		
end;
$$

Language plpgsql;		