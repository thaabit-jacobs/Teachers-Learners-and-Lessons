create or replace function 
	register_new_subject(the_learner_id int, the_subject_id int)
		returns boolean as
		
$$
begin

	insert into learner_subject (learner_id, subject_id) values(the_learner_id, the_subject_id);
	
	return true;
	
end;
$$

Language plpgsql;	