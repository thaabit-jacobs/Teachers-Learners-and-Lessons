create or replace function is_subject_registered(the_subject_id int)
		returns boolean asS
		
$$
declare
total int;

begin

		select into total count(*)