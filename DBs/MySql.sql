create table contact (
	id bigint AUTO_INCREMENT PRIMARY KEY,
	name varchar(100) not null,
	lastName varchar(100) not null,
	email varchar(100) not null,
	password varchar(100) not null,
	createdAt datetime not null,
	lastModified datetime not null
);

insert into contact (name, lastName, email, password, createdAt, lastModified)
values ('Teste 1', 'Last Name', 'teste1@gmail.com', 'teste1', '2019-04-01', '2019-04-01');

insert into contact (name, lastName, email, password, createdAt, lastModified)
values ('Teste 2', 'Last Name', 'teste2@gmail.com', 'teste2', '2019-04-02', '2019-04-02');

insert into contact (name, lastName, email, password, createdAt, lastModified)
values ('Teste 3', 'Last Name', 'teste3@gmail.com', 'teste3', '2019-04-03', '2019-04-03');

insert into contact (name, lastName, email, password, createdAt, lastModified)
values ('Teste 4', 'Last Name', 'teste4@gmail.com', 'teste4', '2019-04-04', '2019-04-04');

insert into contact (name, lastName, email, password, createdAt, lastModified)
values ('Teste 5', 'Last Name', 'teste5@gmail.com', 'teste5', '2019-04-05', '2019-04-05');