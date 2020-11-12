CREATE TABLE employee (
	empno NUMBER PRIMARY KEY, 
	empname varchar2(50) NOT NULL, 
	title varchar2(50), 
	manager NUMBER,
	salary NUMBER, 
	dno NUMBER
);

CREATE TABLE department (
	deptno NUMBER primary KEY,
	deptname varchar2(50) NOT NULL, 
	floor NUMBER
);

ALTER TABLE employee ADD CONSTRAINT FK_EMP_MNG FOREIGN KEY (manager) REFERENCES employee(empno);
ALTER TABLE employee ADD CONSTRAINT FK_DEPT_DNO FOREIGN KEY (dno) REFERENCES department(deptno);