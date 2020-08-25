create or replace function is_subject_registered(the_teacher_id int, the_subject_id int)
		returns boolean as
		
$$
declare
total int;

begin

		select into total count(*) from teacher_subject 
			where teacher_id = the_teacher_id and subject_id = the_subject_id;
			
			if(total >= 1) then
				return true;
				
			else
				return false;
				
				end if;
				
end;
$$
Language plpgsql;		