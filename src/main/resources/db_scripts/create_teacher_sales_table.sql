create table teacher_sales(
	teacher_id int not null,
	menue_item_id int not null,
	foreign key (teacher_id) references teacher(id),
	foreign key (teacher_id) references menue(id)
)