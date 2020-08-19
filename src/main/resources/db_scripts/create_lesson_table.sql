create table lesson(
	id serial primary key not null,
	teacher_id int not null,
	subject_id int not null,
	lesson_time time not null,
	foreign key (teacher_id) references teacher(id),
	foreign key (subject_id) references subject(id)
)