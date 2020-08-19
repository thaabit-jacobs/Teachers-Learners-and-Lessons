create table learner(
	id serial not null primary key,
	first_name text not null,
	last_name text not null,
	email text not null,
	tokens int not null
)