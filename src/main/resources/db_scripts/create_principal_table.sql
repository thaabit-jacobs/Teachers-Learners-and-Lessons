create table principal(
	id serial primary key not null,
	first_name text not null,
	last_name text not null,
	email text not null,
	cancelled_lessons int not null
)