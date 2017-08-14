insert into interest values(1, 'Music');
insert into interest values(2, 'Dance');
insert into interest values(3, 'Sports'); 

insert into account(username, password, firstName, lastName, enabled)
values('Aatika', 'secret', 'Aatika', 'Fatima', true);

insert into poll values(1, 'What is java'); 
insert into options values(1, 'Programing lang', 1 );
insert into options values(2, 'Object Oriented lang', 1 );
insert into options values(3, 'Procedural lang', 1 );
insert into options values(4, 'Rule Based lang', 1 );
insert into vote values( 1, 1);
insert into vote values( 2, 1);
insert into vote values( 3, 1);
insert into vote values( 4, 2);
insert into vote values( 5, 2);

commit;