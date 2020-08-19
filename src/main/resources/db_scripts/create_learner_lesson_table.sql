create table learner_lesson(
	learner_id int not null,
	lesson_id int not null,
	foreign key(learner_id) references learner(id),
	foreign key(lesson_id) references lesson(id)
)