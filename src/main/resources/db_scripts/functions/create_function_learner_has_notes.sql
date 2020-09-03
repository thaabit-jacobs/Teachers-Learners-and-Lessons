create or replace function
	has_lesson_notes(the_learner_id int, the_subject_id int)
	returns boolean as
	
$$
declare

total int;

begin 

	select into total count(*) from lesson_notes
	where learner_id = the_learner_id and subject_id = the_subject_id;
	
	if(total >= 1) then
	return true;
	else
	return false;
	
	end if;
	
end;
$$

Language plpgsql;
	