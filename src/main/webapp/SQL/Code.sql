SELECT DISTINCT e.mgr code, m.ename val
FROM emp100 e, emp100 m
WHERE e.mgr = m.empno
ORDER BY code;

SELECT deptno code, dname val 
FROM dept100
ORDER BY code;

SELECT* FROM dept100;
SELECT * FROM emp100;
SELECT * FROM member100;
SELECT * FROM SALGRADE s ;

SELECT grade code, losal val 
FROM SALGRADE ORDER BY code;


INSERT INTO emp100 values(1001,'마길동','부장',7839,sysdate,7000,1000,10);
INSERT INTO emp100 values(1002,'오길동','차장',1001,sysdate,6000,1000,10);