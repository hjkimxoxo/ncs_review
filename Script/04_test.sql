
SELECT EMPNO,EMPNAME,TITLE,MANAGER,SALARY,DNO FROM employee;
SELECT DEPTNO,DEPTNAME,FLOOR FROM department;


SELECT e.EMPNO,e.EMPNAME,e.TITLE, e.MANAGER, m.EMPNAME AS MNAME, e.SALARY, e.DNO AS dno, d.DEPTNAME, d.FLOOR FROM employee e LEFT OUTER JOIN department d ON e.DNO = d.DEPTNO LEFT OUTER JOIN EMPLOYEE m ON m.EMPNO = e.MANAGER;