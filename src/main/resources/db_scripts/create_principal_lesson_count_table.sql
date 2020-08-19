create table principal_lesson_count(
	subject_id int not null,
	lesson_count int not null,
	foreign key (subject_id) references subject(id)
)