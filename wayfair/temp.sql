/*
CoderPad provides a basic SQL sandbox with the following schema.
You can also use commands like `show tables` and `desc employees`

employees                             projects
+---------------+---------+           +---------------+---------+
| id            | int     |<----+  +->| id            | int     |
| first_name    | varchar |     |  |  | title         | varchar |
| last_name     | varchar |     |  |  | start_date    | date    |
| salary        | int     |     |  |  | end_date      | date    |
| department_id | int     |--+  |  |  | budget        | int     |
+---------------+---------+  |  |  |  +---------------+---------+
                             |  |  |
departments                  |  |  |  employees_projects
+---------------+---------+  |  |  |  +---------------+---------+
| id            | int     |<-+  |  +--| project_id    | int     |
| name          | varchar |     +-----| employee_id   | int     |
+---------------+---------+           +---------------+---------+
*/

/*

first_name, last_name, department name

*/
/* only employees that have departments */
select e.first_name, e.last_name, d.name from employees e inner join departments d on e.department_id = d.id;

/*
departments that don't have employees

*/

/*where d.id not in (select id from employees)*/

select name, e.id from departments d left join employees e on e.department_id = d.id where e.id IS NULL

select project_id, employee_id
from employees_projects

/*

project name, number of employees that worked on that project

*/
/*select p.title, COUNT(ep.employee_id) from projects p inner join employees_projects ep ON p.id = ep.project_id;
*/
/* select count(id) from employees_projects */
/* group_by project_id */
