create or replace function
	is_sub_registered_learner(the_learner_id int, the_subject_id int)
		returns boolean as
		
		
$$
declare

total int;

begin

		select into total count(*) from learner_subject 
			where learner_id = the_learner_id and subject_id = the_subject_id;
			
			
		if(total>=1) then
			return true;
			
		else
			return false;
			
			end if;
			
end;
$$
Language plpgsql;			