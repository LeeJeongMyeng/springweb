
SELECT DISTINCT e.mgr, m.ename
FROM emp100 e, emp100 m
WHERE e.mgr = m.empno;

SELECT DISTINCT job
FROM emp100;

SELECT DISTINCT deptno,dname
FROM dept100;

SELECT e.empno,e.ename,d.dname,m.ename mgrname,e.job FROM EMP100 e, emp100 m ,dept d
WHERE e.MGR = m.empno
AND e.deptno = d.deptno 
and  e.ENAME LIKE  '%'||''||'%'
AND  e.JOB LIKE  '%'||''||'%'
AND  e.MGR LIKE  '%'||''||'%'
AND  e.DEPTNO LIKE  '%'||''||'%';

SELECT * FROM MEMBER111 m 
WHERE mid LIKE  '%'||''||'%'
AND NAME LIKE  '%'||''||'%'
AND AUTH LIKE  '%'||''||'%';

SELECT * FROM MEMBER111 m 
		WHERE mid LIKE  '%'||''||'%'
		AND NAME LIKE  '%'||''||'%'
		AND AUTH LIKE  '%'||''||'%';
		
update member111
set pass='1111'
where mid='himan';

SELECT DISTINCT auth FROM member111;