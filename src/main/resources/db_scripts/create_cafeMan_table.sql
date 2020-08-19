create table cafeMan(
	id serial primary key not null,
	first_name text not null,
	last_name text not null,
	email text not null,
	total_tokens int not null
)