
create table user_table (
  userid serial primary key,
  username text  not null unique,
  user_password text not null unique,
  firstName text,
  lastName text 
  );
create table department_table (
	departmentid serial primary key,
	departmentname text
);

select * from department_table;
insert into department_table values(default,'Math');
insert into department_table values(default,'Computer');
select * from  department_table;
create table student_table (
	studentid serial primary key,
	firstname text,
	lastnam text,
	department_id int references department_table (departmentid),
	user_id int references usertable (userid)
);
select * from student_table;

select s.studentid , s.firstname, s.lastnam, d.departmentid, d.departmentname, u.userid, u.firstname  from student_table s
   inner join department_table d on s.department_id=d.departmentid 
   inner join usertable u on  s.user_id= u.userid;
  
insert into student_table values (default,'Hana','adm',2,2);
insert into student_table values (default,'Hana','adm',2,2);
insert into student_table values (default,'Hana','adm',2,2);
insert into student_table values (default,'Hana','adm',2,2);
select studentid from student_table group by studentid;
create table instructer_table (
	instructerid serial primary key,
	firstname text,
	lastnam text,
	user_id int references usertable (userid)
);
select * from instructer_table;
select * from instructer_table inner join usertable on instructer_table.instructerid = usertable.userid where instructer_table.firstname = 'Mohamed';
insert into instructer_table values (default,'Usama', 'Samy',20);
insert into instructer_table values (default,'Emad', 'majed',19);
insert into instructer_table values (default,'Mohamed', 'Albakosh',1)
insert into instructer_table values (default,'Mohamed', 'Albakosh',1)

select * from usertable;


create or replace function get_student_count()
returns int  as $$
declare
   student_count int;
begin
   select student_id into student_count from semester_table inner join student_table  on semester_table.student_id=student_table.studentid group by student_id  ; 
   
  return student_count;
end;
$$  language plpgsql;

select get_student_count();
create table courser_table (
	courseid serial primary key,
	coursename text,
	department_id int references department_table (departmentid),
	instructer_id int references instructer_table (instructerid)
);
select * from courser_table ;
insert into courser_table values(default,'Database',2,3);

drop table semester_table;
create table semester_table (
	Semesterid serial primary key,
	Semestertname text,
	student_id int references student_table (studentid),
	courser_id int references courser_table (courseid),
	department_id int references department_table (departmentid),
	instructer_id int references instructer_table (instructerid)
);
select * from semester_table;
select * from usertable;
insert into usertable values (default,'usama','pass66','Usama','Samy','usama@gmail.com',5);
insert into usertable values (default,'ahmad','pass88','Ahmad','Basem','Ahmad@gmail.com',5);
select * from roletable ;
select * from usertable inner join roletable on  usertable.role_id = roletable.roleid where username = 'ali';
select * from usertable inner join roletable on usertable.role_id = roletable.roleid where usertable.username = 'ali';
select student_id from semester_table inner join student_table  on semester_table.student_id=student_table.studentid   group by student_id;
select * from instructer_table inner join usertable on instructer_table.instructerid = usertable.userid where instructer_table.firstname = 'ali';
select * from roletable;
INSERT INTO roletable VALUES (default,'Student');
INSERT INTO roletable VALUES (default,'Instructer');
select firstname from student_table; 
select * from usertable  inner join roletable on usertable.role_id=roletable.roleid where username ='ali';
select s.studentid , s.firstname, s.lastnam, d.departmentid , d.departmentname, u.userid, u.firstname  from student_table s
				   inner join department_table d on s.department_id=d.departmentid 
				   inner join usertable u on  s.user_id= u.userid  where username ='Ali';

