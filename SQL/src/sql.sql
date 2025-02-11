create table maxima.departments (
id varchar(100) primary key,
name text unique
)

create table maxima.employees (
id serial primary key,
name varchar(100),
position varchar(100),
salary decimal(10,2),
hire_date date,
department_id varchar references maxima.departments (id)
)

insert into maxima.departments (id, name)
values
(1, 'IT'),
(2, 'HR'),
(3, 'Marketing')

insert into maxima.employees (id, name, position, salary, hire_date, department_id)
values
(1, 'Alex', 'Разработчик', 150000, '2024-10-15', 1),
(2, 'Viktor', 'Маркетолог', 110000, '2022-01-11', 3),
(3, 'Rinat', 'Разработчик', 180000, '2021-12-31', 1),
(4, 'Ivan', 'Разработчик', 170000, '2022-09-12', 1),
(5, 'Olga', 'Рекрутер', 120000, '2024-03-19', 2)

-- Вывести всех сотрудников и их департаменты.
select * from maxima.employees e
join maxima.departments d on e.department_id = d.id

-- Вывести сотрудников, у которых зарплата выше 70 000.
select name, salary from maxima.employees where salary > 70000

-- Найти сотрудников, нанятых после 2022 года.
select name, hire_date from maxima.employees where hire_date > '2021-12-31'

-- Вывести количество сотрудников в каждом департаменте.
select d.name, count(*) as count from maxima.departments d
join maxima.employees e on e.department_id = d.id
group by d.name

-- Найти департаменты, в которых работают сотрудники с должностью Разработчик.
select e.name as employeer, e.position, d.name as department from  maxima.employees e
join maxima.departments d on d.id = e.department_id
where e.position = 'Разработчик'

-- Добавьте индексы на столбцы, которые часто используются в WHERE.
CREATE INDEX idx_salary ON maxima.employees(salary);

-- Посмотрите, как изменится производительность запросов.
-- Время выполнения запроса без индекса
-- Seq Scan on employees  (cost=0.00..1.06 rows=2 width=468) (actual time=0.010..0.011 rows=5 loops=1)
-- Время выполнения запроса с индексом
-- Seq Scan on employees  (cost=0.00..1.06 rows=2 width=468) (actual time=0.006..0.007 rows=5 loops=1)









