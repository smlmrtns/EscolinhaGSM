create table professor(
	idprofessor bigint auto_increment,
	nome varchar(30) not null,
	sexo varchar(30) not null,
	idade int not null,
	primary key(idprofessor)
);

create table turma(
	idturma bigint auto_increment,
	materia varchar(30) not null,
	idprofessor bigint not null,
	primary key(idturma),
	foreign key(idprofessor) references professor(idprofessor)
);

create table aluno(
	idaluno bigint auto_increment,
	nome varchar(30) not null,
	sexo varchar(30) not null,
	idade int not null,
	n1 decimal(10,2),
	n2 decimal(10,2),
	idturma bigint not null,
	primary key(idaluno),
	foreign key(idturma) references turma(idturma)
);

create table direcao(
	idfuncionario bigint auto_increment,
	nome varchar(30) not null,
	sexo varchar(30) not null,
	idade int not null,
	cargo varchar(30) not null,
	primary key(idfuncionario)
);



create table usuario(
    idusuario bigint auto_increment,
    login varchar(50) not null,
    senha varchar(50) not null,
    primary key(idusuario));

insert into usuario(idusuario,login,senha)
values(null,'login','login');