create or replace function
	has_three_more_subjects(the_learner_id int)
		returns int as
		
$$
declare

total int;

begin

	select intO total COUNT(subject_id) as subject_count from learner_subject
		where learner_id = the_learner_id;
		
		return total;
		
end;
$$

Language plpgsql;		