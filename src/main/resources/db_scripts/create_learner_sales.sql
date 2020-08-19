create table learner_sales(
	learner_id int not null,
	menue_item_id int not null,
	foreign  key(learner_id) references learner(id),
	foreign  key(menue_item_id) references menue(id)
)