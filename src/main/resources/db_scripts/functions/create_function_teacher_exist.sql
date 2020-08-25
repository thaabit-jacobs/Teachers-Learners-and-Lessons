create or replace function
	teacher_exist(the_teacher_email text)
	returns boolean as

$$
declare

total int;

begin

	select into total count(*) from teacher where 				        LOWER(email)=LOWER(the_teacher_email);

	if(total=1) then
		return true;

	else

		return false;

	end if;

end;
$$

Language plpgsql;

